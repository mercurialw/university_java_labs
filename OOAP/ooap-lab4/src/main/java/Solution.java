public class Solution {
    public static void main(String[] args) {
        ArmyFactory goblinArmyFactory = new GoblinArmyFactory();
        ArmyFactory orcArmyFactory = new OrcArmyFactory();

        Commander goblinCommander = goblinArmyFactory.createCommander();
        General goblinGeneral = goblinArmyFactory.createGeneral();
        Soldier goblinSoldier = goblinArmyFactory.createSoldier();

        goblinCommander.lead();
        goblinGeneral.command();
        goblinSoldier.fight();

        System.out.println();

        Commander orcCommander = orcArmyFactory.createCommander();
        General orcGeneral = orcArmyFactory.createGeneral();
        Soldier orcSoldier = orcArmyFactory.createSoldier();

        orcCommander.lead();
        orcGeneral.command();
        orcSoldier.fight();
    }
}
