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
        int[] wealthSize = new int[Wealth.values().length];

        int insertNum = 1;

        if (this.race == Characteristic.ASIAN) {

            //Christian
            religionSize[0] = insertNum;
            //Muslim
            religionSize[1] = insertNum;
            //Jewish
            religionSize[2] = insertNum;
            //Buddhist
            religionSize[3] = insertNum;
            //Hindu
            religionSize[4] = insertNum;
            //Secular
            religionSize[5] = insertNum;

            //Poor
            wealthSize[0] = insertNum;
            //Lower_Middle
            wealthSize[1] = insertNum;
            //Middle
            wealthSize[2] = insertNum;
            //Upper_Middle
            wealthSize[3] = insertNum;
            //Rich
            wealthSize[4] = insertNum;

        } else if (this.race == Characteristic.BLACK) {

            //Christian
            religionSize[0] = insertNum;
            //Muslim
            religionSize[1] = insertNum;
            //Jewish
            religionSize[2] = insertNum;
            //Buddhist
            religionSize[3] = insertNum;
            //Hindu
            religionSize[4] = insertNum;
            //Secular
            religionSize[5] = insertNum;

            //Poor
            wealthSize[0] = insertNum;
            //Lower_Middle
            wealthSize[1] = insertNum;
            //Middle
            wealthSize[2] = insertNum;
            //Upper_Middle
            wealthSize[3] = insertNum;
            //Rich
            wealthSize[4] = insertNum;

        } else if (this.race == Characteristic.HISPANIC) {

            //Christian
            religionSize[0] = insertNum;
            //Muslim
            religionSize[1] = insertNum;
            //Jewish
            religionSize[2] = insertNum;
            //Buddhist
            religionSize[3] = insertNum;
            //Hindu
            religionSize[4] = insertNum;
            //Secular
            religionSize[5] = insertNum;

            //Poor
            wealthSize[0] = insertNum;
            //Lower_Middle
            wealthSize[1] = insertNum;
            //Middle
            wealthSize[2] = insertNum;
            //Upper_Middle
            wealthSize[3] = insertNum;
            //Rich
            wealthSize[4] = insertNum;

        } else if (this.race == Characteristic.WHITE) {

            //Christian
            religionSize[0] = insertNum;
            //Muslim
            religionSize[1] = insertNum;
            //Jewish
            religionSize[2] = insertNum;
            //Buddhist
            religionSize[3] = insertNum;
            //Hindu
            religionSize[4] = insertNum;
            //Secular
            religionSize[5] = insertNum;

            //Poor
            wealthSize[0] = insertNum;
            //Lower_Middle
            wealthSize[1] = insertNum;
            //Middle
            wealthSize[2] = insertNum;
            //Upper_Middle
            wealthSize[3] = insertNum;
            //Rich
            wealthSize[4] = insertNum;

        } else if (this.race == Characteristic.MIDDLE_EASTERN) {

            //Christian
            religionSize[0] = insertNum;
            //Muslim
            religionSize[1] = insertNum;
            //Jewish
            religionSize[2] = insertNum;
            //Buddhist
            religionSize[3] = insertNum;
            //Hindu
            religionSize[4] = insertNum;
            //Secular
            religionSize[5] = insertNum;

            //Poor
            wealthSize[0] = insertNum;
            //Lower_Middle
            wealthSize[1] = insertNum;
            //Middle
            wealthSize[2] = insertNum;
            //Upper_Middle
            wealthSize[3] = insertNum;
            //Rich
            wealthSize[4] = insertNum;

        }

        wealth = getWealth(wealthSize);
        religion = getReligion(religionSize);
    }

    private Characteristic getWealth(int[] wealthSizes) {
        int index = getRandomWeightedIndex(wealthSizes);
        if (index == 0) {
            return Characteristic.POOR;
        } else if (index == 1) {
            return Characteristic.LOWER_MIDDLE;
        } else if (index == 2) {
            return Characteristic.MIDDLE;
        } else if (index == 3) {
            return Characteristic.UPPER_MIDDLE;
        } else if (index == 4) {
            return Characteristic.RICH;
        }
        throw new RuntimeException("Unrecognized Wealth Index");
    }

    private Characteristic getReligion(int[] religionSizes) {
        int index = getRandomWeightedIndex(religionSizes);
        if (index == 0) {
            return Characteristic.CHRISTIAN;
        } else if (index == 1) {
            return Characteristic.MUSLIM;
        } else if (index == 2) {
            return Characteristic.JEWISH;
        } else if (index == 3) {
            return Characteristic.BUDDHIST;
        } else if (index == 4) {
            return Characteristic.HINDU;
        } else if (index == 5) {
            return Characteristic.SECULAR;
        }
        throw new RuntimeException("Unrecognized Religion Index");
    }

    private int getRandomWeightedIndex(int[] array) {
        int totalValue = 0;

        for (int arrayVal : array) {
            totalValue += arrayVal;
        }

        int choiceNum = (int) (Math.random() * totalValue);

        for (int i = 0; i < array.length; i++) {
            choiceNum -= array[i];

            if (choiceNum < 0) {
                return i;
            }
        }

        throw new RuntimeException("Weighted Index Function Broken");
    }

    public boolean hasCharacteristic(Characteristic characteristic) {
        return race == characteristic ||
                sex == characteristic ||
                religion == characteristic ||
                wealth == characteristic;
    }

    @Override
    public String toString() {
        return "Race: " + race.toString().toLowerCase() + " Sex: " + sex.toString().toLowerCase() + " Religion: " + religion.toString().toLowerCase() + " Income: " + wealth.toString().toLowerCase();
    }
}
