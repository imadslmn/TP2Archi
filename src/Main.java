import Classes.AffichageComposite;
import Classes.AffichageDate;
import Classes.AffichageEcran;
import Classes.AffichageFile;
import Classes.Etudiant;
import Classes.EtudiantRepository;
import Classes.EtudiantService;
import Classes.Premuim;
import Classes.Standard;
import Classes.Universite;
import Classes.UniversiteRepository;
import Classes.ViewInscription;
import Interfaces.IJournal;
import Interfaces.InterfaceEtudiantRepository;
import Interfaces.InterfaceEtudiantService;
import Interfaces.InterfaceUniversiteRepository;
import Interfaces.TypePackage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Initialisation  des types d'affichages.
        AffichageComposite AffichageListes = new AffichageComposite();
        IJournal AffichageEcran = new AffichageEcran();
        IJournal AffichageDate = new AffichageDate();
        IJournal AffichageFile = new AffichageFile();
        AffichageListes.addAffichage(AffichageFile);
        AffichageListes.addAffichage(AffichageEcran);
        AffichageListes.addAffichage(AffichageDate);
        
        // Initialisation  les bnous.
        Standard standard = new Standard();  
        standard.setBonus(10);
        Premuim premuim = new Premuim();  
        premuim.setBonus(30);

        // Creation des objets  Universite repository, Etudiant repository, Etudiant Service, Etudiant, Univeriste
        InterfaceEtudiantRepository etudiantRepository = new EtudiantRepository(AffichageListes);
        InterfaceUniversiteRepository universiteRepository = new UniversiteRepository(AffichageListes);
        InterfaceEtudiantService serv=new EtudiantService(etudiantRepository,universiteRepository, AffichageListes);
        List<Etudiant> listEtudiants=new ArrayList<Etudiant>();  
        listEtudiants.add(new Etudiant(1, "SELMANE", "Imad Eddine", "imadeddine@gmail.com", "xxxx", 1));
        listEtudiants.add(new Etudiant(2, "LAROUBI", "Sabri", "sabri@gmail.com", "xxxx", 1));
        listEtudiants.add(new Etudiant(3, "BABOURE", "Ali", "mohammed@gmail.com", "xxxx", 3));
        listEtudiants.add(new Etudiant(4, "Guendouziiiii", "wassila", "guen@gmail.com", "xxxx", 2));

        List<Universite> listUniversite=new ArrayList<Universite>(); 
        listUniversite.add(new Universite(3,"ESI", TypePackage.Illimite)); 
        listUniversite.add(new Universite(1,"USTHB", TypePackage.Premium));
        listUniversite.add(new Universite(2,"Benyoucef Ben Khedda", TypePackage.Standard));
        ViewInscription V = new ViewInscription(etudiantRepository);

        try {
            for(Etudiant etudiant:listEtudiants){
                for(Universite universite:listUniversite){
                    if(etudiant.getId_universite() == universite.getI_univ()){
                        serv.inscription(etudiant,universite, etudiantRepository, universiteRepository);
                     }
                }
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

