package com.stab.data.info;

import com.stab.data.actions.player.spells.DismissSpellAction;
import com.stab.data.actions.player.spells.Spell;
import com.stab.data.actions.player.spells.SpellProperties;
import com.stab.data.actions.player.spells.SpellUtils;
import com.stab.data.actions.player.spells.lvl0.DetectMagic;
import com.stab.model.action.ActionLibrary;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.Token;
import com.stab.model.extras.ContextualOption;
import com.stab.model.extras.OnlyVisibleWithMode;
import com.stab.model.info.Info;
import com.stab.model.info.interfaces.PlayerOwned;
import com.stab.model.info.trait.base.VisualEffect;

/**
 * Efecto de un hechizo estandar. Las subclases se ocuparan de determinar si es buff o debuff implementando la interfaz correspondiente
 * Aporta varias cosas. Tiene un token por defecto, que es solo visible con VisionMode magic
 * Muy probablemente pondremos a ese token solo una informacion basica, ampliable con una tirada de spellcraft (disguisesAs)
 * El token tendra el tag de dispelleable, con vistas a quitarlo con dispel magic
 * Tendra una contextual action para hacer dismiss si es dismissable (pendiente de hacer que solo la tenga su caster)
 * 
 * algunos efectos son tan visibles que se sobreescribira el solo verlo con visionMode (es opcion de cada hechizo)
 * 
 * probablemente use un icono distinto dependiendo de si el caster es player o no (para que no revele automaticamente que hechizo es)
 * 
 * tendra un metodo para renovar automaticamente la duracion (por si se castea otro) 
 */
public class SpellEffect extends VisualEffect {

	
	Spell spell; //El spell del que proviene, para tener informacion adicional
	Info caster;//El caster original (ojo, que puede ser null? para varitas, pociones, etc?)
				//Es con vistas a dismiss
	//int casterLevel;//El caster level final con el que se lanzo (en el spell no esta calculado, por eso se apunta aqui)
	
	boolean evident=false; //Si el efecto es evidente
	boolean identified=false;
	String effectResource;
	ContextualOption dismiss;
	
	public SpellEffect(Spell spell, Info caster) {
		super();
		this.spell = spell;
		this.caster = caster;
	//	this.casterLevel = casterLevel;
		setSound("HolyCast");
		setAnimIcon(spell.getResource());
		setResource(spell.getResource());
		setName(spell.getText());
		
		
		recalcDuration();
		recalcSpecialEffect();
		this.setIdentified(spell.isIdentified());
	}

	
	
	
	public void setEffectResource(String effectResource) {
		this.effectResource = effectResource;
	}
	

	public void setEvident(boolean evident) {
		this.evident = evident;
	}
	public boolean isEvident() {
		return evident;
	}

	public Spell getSpell() {
		return spell;
	}
	
	public int getCasterLevel() {
		return spell.getFinalCasterLevel();
	}
	
	public Info getCaster() {
		return caster;
	}

	protected void recalcDuration() {
		switch(getSpell().getDuration()){
			case SpellProperties.INSTANT: this.setTillEndOfTurn();break;
			case SpellProperties.ROUND: this.setTime(1);break;
			case SpellProperties.SHORT: this.setTime(getCasterLevel()*10);break;
			case SpellProperties.MEDIUM: this.setTime(getCasterLevel()*100);break;
			case SpellProperties.LONG: this.setTime(getCasterLevel()*600);break;
			case SpellProperties.PERMANENT: this.setPermanent();break;
			default: setTime(1);
		}
	}

	protected void recalcSpecialEffect() {
		this.setEffectResource(SpellUtils.getVisualAura(getSpell()));
	}
	
	public String getEffectResource() {
		return effectResource;
	}
	
	@Override
	protected Sprite createEffectSprite() {
		SpellDecoration e=new SpellDecoration(this);
		e.setResource(getEffectResource());
		e.setSelectable(Token.SELECTABLE_MENU);
		if (!isEvident()){
			e.setHidden();
			e.setHideCheck(-1); //evita que se detecte por search
			//visionMode
			e.addExtra(new OnlyVisibleWithMode(DetectMagic.VISIONMODE));
		}
		if (this.getSpell().isDismissable()){
			dismiss= new ContextualOption();
			dismiss.setAction(ActionLibrary.getActionLibrary().getAction(DismissSpellAction.ID));
			e.addExtra(dismiss);
		}
		
		return e;
	}
	
	public boolean isIdentified() {
		if (getCaster() instanceof PlayerOwned)
			return true;
		return identified;
	}
	
	public void setIdentified(boolean identified) {
		this.identified = identified;
	}
	
	
	@Override
	public String getAnimIcon() {
		if (isIdentified())
			return super.getAnimIcon();
		return "actions/spells/unknown_spell";
	}
	
	@Override
	protected void configureEffectSprite(Sprite es) {
		super.configureEffectSprite(es);
		if (this.getTarget()!=null)
			if (this.getTarget().getToken()!=null)
				dismiss.setAllowedActor(getTarget().getToken());
		
	}
	
	
	
}