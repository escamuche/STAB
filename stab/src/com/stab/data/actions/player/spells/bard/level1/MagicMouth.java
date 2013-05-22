package com.stab.data.actions.player.spells.bard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.info.Info;

public class MagicMouth extends SpellOnTile{

	public static final String ID="MAGICMOUTH";
	
	public MagicMouth() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.BARDCASTER);
		 setRange(CLOSE);
	     setResource("actions/hypnotism");
	     setName("Magic Mouth");
	     this.setDescription("This spell imbues the chosen object or creature with an enchanted mouth that suddenly appears and speaks its message the next time a specified event occurs. The message, which must be 25 or fewer words long, can be in any language known by you and can be delivered over a period of 10 minutes. The mouth cannot utter verbal components, use command words, or activate magical effects. It does, however, move according to the words articulated; if it were placed upon a statue, the mouth of the statue would move and appear to speak. Magic mouth can also be placed upon a tree, rock, or any other object or creature." +
	    		 "The spell functions when specific conditions are fulfilled according to your command as set in the spell. Commands can be as general or as detailed as desired, although only visual and audible triggers can be used. Triggers react to what appears to be the case. Disguises and illusions can fool them. Normal darkness does not defeat a visual trigger, but magical darkness or invisibility does. Silent movement or magical silence defeats audible triggers. Audible triggers can be keyed to general types of noises or to a specific noise or spoken word. Actions can serve as triggers if they are visible or audible. A magic mouth cannot distinguish alignment, level, Hit Dice, or class except by external garb." +
	    		 "The range limit of a trigger is 15 feet per caster level, so a 6th-level caster can command a magic mouth to respond to triggers as far as 90 feet away. Regardless of range, the mouth can respond only to visible or audible triggers and actions in line of sight or within hearing distance." +
	    		 "Magic mouth can be made permanent with a permanency spell.");
	 
	}


	@Override
	public boolean affect(Info instigator, Info target,Point point) {
		// TODO Auto-generated method stub
		return false;
	}
}