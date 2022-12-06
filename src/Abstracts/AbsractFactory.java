package Abstracts;
import Classes.Illimité;
import Classes.Premuim;
import Classes.Standard;
import Interfaces.Package;
import Interfaces.TypePackage;
public class AbsractFactory {
    public AbsractFactory(){}
    public Package getPackage(TypePackage TP){
        if(TP.equals(TypePackage.Standard)){
			return new Standard();
			
		}else if(TP.equals(TypePackage.Premium)){
			return new Premuim();
		}
        return new Illimité();
    }
}
