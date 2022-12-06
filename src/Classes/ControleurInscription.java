package Classes;
import javax.swing.*;
public class ControleurInscription {
    public void ShowErreur(String msg) {
        JOptionPane.showMessageDialog(new JFrame(), msg, "Erreur", 0);
    }
    private Boolean status;
    public  ControleurInscription(ViewInscription View){
        if (View.getMatriculeText().isEmpty() || View.getLastNameText().isEmpty() || View.getFirstNameText().isEmpty() || View.getEmailTex().isEmpty() || View.getPasswordText().isEmpty() || View.getUniversiteText().isEmpty()) {
            this.ShowErreur("veuillez remplir tous les champs");
            setStatus(false);
        }
        if (!View.getMatriculeText().matches("-?\\d+") || !View.getMatriculeText().matches("-?\\d+")) {
            this.ShowErreur("les champs matricule et id universite doivent etre de format numeriques ");
            setStatus(false);
        }
        if (!View.getEmailTex().matches("^(.+)@(.+)$")) {
            this.ShowErreur("il faut respecter le format d'un email xxx@xxx.xxx");
            setStatus(false);
        }
        setStatus(true);
    }
    public boolean getStatus(){return this.status;}
    public void setStatus(Boolean status) {
        this.status = status;
    }
}
