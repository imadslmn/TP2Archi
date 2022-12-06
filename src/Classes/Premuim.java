package Classes;

import Interfaces.Package;

public class Premuim implements Package {
    static int bonus;
    @Override
    public void setBonus(int B) {
        bonus = B;
    }
    @Override
    public int getBonus() {
        return bonus;
    }
    @Override
    public void setNbLivreMensuelAutorise(Etudiant etudiant) {
        // TODO Auto-generated method stub
        etudiant.setNbLivreMensuel_Autorise(20);
    }
}