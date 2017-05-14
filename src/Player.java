import PlayerAttributes.*;

/**
 * Created by austinzhang on 5/13/17.
 */
public class Player {
    private Characteristic race;
    private Characteristic sex;
    private Characteristic religion;
    private Characteristic wealth;

    public Player(Characteristic race, Characteristic sex) {
        this.race = race;
        this.sex = sex;

        generateReligionAndWealth();
    }

//NEED TO MAKE
    private void generateReligionAndWealth() {
        int[] religionSize = new int[Religion.values().length];


        if (this.race == Characteristic.ASIAN) {

        } else if (this.race == Characteristic.BLACK) {

        } else if (this.race == Characteristic.HISPANIC) {

        } else if (this.race == Characteristic.WHITE) {

        }

        religion = Characteristic.CHRISTIAN;
        wealth = Characteristic.MIDDLE;
    }

    public boolean hasCharacteristic(Characteristic characteristic) {
        return race == characteristic ||
                sex == characteristic ||
                religion == characteristic ||
                wealth == characteristic;
    }


}
