package Interfaces;
import java.sql.SQLException;

import Classes.Etudiant;

public interface InterfaceUniversiteRepository {
    InterfaceUniversite GetById(int universityId) throws SQLException;

//    void setNbLivreMensuelAutorise(Etudiant etudiant, TypePackage pack);
}
