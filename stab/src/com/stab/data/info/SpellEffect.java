package com.stab.data.info;

import com.stab.data.actions.player.spells.Spell;
import com.stab.data.actions.player.spells.SpellProperties;
import com.stab.data.actions.player.spells.SpellUtils;
import com.stab.data.actions.player.spells.lvl0.DetectMagic;
import com.stab.model.basic.Sprite;
import com.stab.model.extras.OnlyVisibleWithMode;
import com.stab.model.info.Info;
import com.stab.model.info.base.EffectDecoration;
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
	int casterLevel;//El caster level final con el que se lanzo (en el spell no esta calculado, por eso se apunta aqui)
	
	boolean evident=false; //Si el efecto es evidente
	String effectResource;
	
	public SpellEffect(Spell spell, Info caster, int casterLevel) {
		super();
		this.spell = spell;
		this.caster = caster;
		this.casterLevel = casterLevel;
		recalcDuration();
		recalcSpecialEffect();
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
		return casterLevel;
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
		
		if (!isEvident()){
			e.setHidden();
			e.setHideCheck(-1); //evita que se detecte por search
			//visionMode
			e.addExtra(new OnlyVisibleWithMode(DetectMagic.VISIONMODE));
		}
		
		return e;
	}
	
	
	
	
	
	
	
	
	
}
