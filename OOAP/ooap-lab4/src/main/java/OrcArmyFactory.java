public class OrcArmyFactory implements ArmyFactory {
    @Override
    public Commander createCommander() {
        return new OrcCommander();
    }

    @Override
    public General createGeneral() {
        return new OrcGeneral();
    }

    @Override
    public Soldier createSoldier() {
        return new OrcSoldier();
    }
}
