package Classes;
import Interfaces.IJournal;
import Interfaces.InterfaceEtudiant;
import Interfaces.InterfaceEtudiantRepository;
import Interfaces.InterfaceEtudiantService;
import Interfaces.InterfaceUniversite;
import Interfaces.InterfaceUniversiteRepository;
import Interfaces.Package;
import java.sql.SQLException;
import java.util.ArrayList;
import Abstracts.AbsractFactory;

public class EtudiantService implements InterfaceEtudiantService {
	private InterfaceEtudiantRepository etudiantRepository;
    private InterfaceUniversiteRepository universiteRepository;
	private IJournal AffichageListes;
	public void AjouerBonusEtudiant(Etudiant etudiant, InterfaceUniversiteRepository universiteRepository) throws SQLException{	
		InterfaceUniversite universite = universiteRepository.GetById(etudiant.getId_universite());
		AbsractFactory AB = new AbsractFactory();
		Package P = AB.getPackage(universite.getPack());
		etudiant.bonus(P.getBonus());
	}	
   public EtudiantService(InterfaceEtudiantRepository etudiantRepository , InterfaceUniversiteRepository universiteRepository, IJournal AffichageListes) {
		super();
		this.etudiantRepository = etudiantRepository;
		this.universiteRepository = universiteRepository;
		this.AffichageListes = AffichageListes;
   }
	@Override
	public boolean inscription(Etudiant etudiant, InterfaceUniversite universite, InterfaceEtudiantRepository etudiantRepository, InterfaceUniversiteRepository universiteRepository) throws SQLException {
		AffichageDate.setClassName("classname : EtudiantService");
		AffichageListes.outPut_Msg("Log: début de l'opération d'ajout de l'étudiant avec matricule " + etudiant.getMatricule());
		if (etudiantRepository.StudentVerification(etudiant)) {
			AbsractFactory AB = new AbsractFactory();
			Package P = AB.getPackage(universite.getPack());
			P.setNbLivreMensuelAutorise(etudiant);
			etudiantRepository.add(etudiant);
			AffichageDate.setClassName("classname : EtudiantService");
			AffichageListes.outPut_Msg("Log: Fin de l'operation d'ajout de l'etudiant avec matricule " + etudiant.getMatricule());
			return true;
		}
		return false;
	}
	@Override
	public ArrayList<InterfaceEtudiant> GetEtudiantParUniversitye(){
	return new ArrayList<>(4);
	}

	@Override
	public ArrayList<InterfaceEtudiant> GetEtudiatparLivreEmprunte(){
	return new ArrayList<>(4);
	}
		
}
