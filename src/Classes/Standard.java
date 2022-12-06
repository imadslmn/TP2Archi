package Classes;
import Interfaces.Package;

public class Standard implements  Package{
    static int bonus; 
    public Standard(){}
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
        etudiant.setNbLivreMensuel_Autorise(10);
    }
}
