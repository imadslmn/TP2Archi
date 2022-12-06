package Interfaces;
import Classes.Etudiant;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceEtudiantService {
    public boolean inscription (Etudiant etudiant, InterfaceUniversite universite, InterfaceEtudiantRepository etudiantRepository, InterfaceUniversiteRepository universiteRepository) throws SQLException;
    public ArrayList<InterfaceEtudiant> GetEtudiantParUniversitye();
    public ArrayList<InterfaceEtudiant> GetEtudiatparLivreEmprunte();
}

