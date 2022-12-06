package Classes;

import Interfaces.IJournal;

public class AffichageEcran implements IJournal {
    public AffichageEcran(){}
    @Override
    public void outPut_Msg(String message) {
        System.out.println(message);
    }
}