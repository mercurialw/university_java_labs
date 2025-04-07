public class AttackCommand implements Command {

    private Player attacker;
    private Player defender;

    @Override
    public void execute() {
        defender.setHp(defender.getHp() - attacker.getDamage());
    }

    @Override
    public void undo() {
        defender.setHp(defender.getHp() + attacker.getDamage());
    }

    public AttackCommand(Player attacker, Player defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public Player getAttacker() {
        return attacker;
    }

    public void setAttacker(Player attacker) {
        this.attacker = attacker;
    }

    public Player getDefender() {
        return defender;
    }

    public void setDefender(Player defender) {
        this.defender = defender;
    }
}
