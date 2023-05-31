package src.Model;

import java.io.Serializable;

/**
 * This program creates a hero character.
 *
 * Code from class.
 *
 * @author Anastasia Vilenius
 * @version 05/09/23
 */
public class heroThree extends Hero implements Serializable {

    /**
     * Indicates minimum of damage that can be generated from a special attack.
     */
    private int myMinSpecialDamage;

    /**
     * Indicates maximum of damage that can be generated from a special attack.
     */
    private int myMaxSpecialDamage;

    /**
     * Constructor that initializes fields.
     *
     * @param theName the name chosen by the player for the hero
     */
    public heroThree (final String theName) {
        super(theName, 120, 20, 40, .9, 3, 3, .4);
    }

    /**
     * Checks to make sure maximum amount of damage generated by special attack is above 0.
     * @param theMaxSpecialDamage the maximum of damage that can be created by a special attack
     */
    private void setMaxSpecialDamage(final int theMaxSpecialDamage) {
        if (theMaxSpecialDamage <= 0) {
            throw new IllegalArgumentException("special skill max damage must be greater than 0");
        }
        myMaxSpecialDamage = theMaxSpecialDamage;
    }

    /**
     * Checks to make sure minimum amount of damage generated by special attack is above 0.
     * @param theMinSpecialDamage the minimum amount of damage that can be generated by a special attack
     */
    private void setMinSpecialDamage(final int theMinSpecialDamage) {
        if (theMinSpecialDamage <= 0) {
            throw new IllegalArgumentException("special skill min damage must be greater than 0");
        }
        myMinSpecialDamage = theMinSpecialDamage;
    }

    /**
     * Overrides specialAttack method in Adventurer class by allowing Centaur a chance
     * to use a crushing blow special attack.
     *
     * @param theOpponent the monster that the hero is battling
     */
    @Override
    protected void specialAttack(final Adventurer theOpponent) {
        System.out.print(getName() + " tries to use Crushing Blow");
        if(canUseSpecialSkill()) {
            int damage = generateSpecialDamage();

            System.out.println(" and hits for **" + damage + "** damage!!");
        }
        else {
            System.out.println(" but it fails :-(");
        }
    }

    /**
     * Generates range of values of special attack damage.
     *
     * @return range of values of special attack damage
     */
    private int generateSpecialDamage() {
        return Adventurer.generateRangedValue(myMinSpecialDamage, myMaxSpecialDamage);
    }
}
