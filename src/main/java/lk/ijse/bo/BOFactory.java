package lk.ijse.bo;

import lk.ijse.bo.custom.impl.StudentBOImpl;
import lk.ijse.bo.custom.impl.ProgramBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public static SuperBO getBO(BOTypes type) {
        switch (type) {
            case STUDENT:
                return (SuperBO) new StudentBOImpl();
            case PROGRAM:
                return (SuperBO) new ProgramBOImpl();
            default:
                throw new IllegalArgumentException("Invalid BO Type");
        }
    }

    public enum BOTypes {
        STUDENT, PROGRAM
    }
}
