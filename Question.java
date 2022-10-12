package z1913793.cs.niu.edu.math_tutor_kids_app;

import android.app.Activity;

public class Question extends Activity {

    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String TYPE;

    private String ANSWER;


    public Question() {
        ID = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";
        TYPE = "";

        ANSWER = "";

    }//end Question

    public Question(String qUESTION, String oPTA, String oPTB, String oPTC,String tYPE,
                    String aNSWER) {
        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;
        TYPE =tYPE;

        ANSWER = aNSWER;

    }//end Question

    public int getID() {
        return ID;
    }//end getID

    public String getQUESTION() {
        return QUESTION;
    }//end getQUESTION

    public String getOPTA() {
        return OPTA;
    }//end getOPTA

    public String getOPTB() {
        return OPTB;
    }//end getOPTB

    public String getOPTC() {
        return OPTC;
    }//end getOPTC
    public String getTYPE() {
        return TYPE;
    }//end getTYPE

    public String getANSWER() {
        return ANSWER;
    }//end getANSWER

    public void setID(int id) {
        ID = id;
    }//end setID

    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }//end setQUESTION

    public void setOPTA(String oPTA) {
        OPTA = oPTA;
    }//end setOPTA

    public void setOPTB(String oPTB) {
        OPTB = oPTB;
    }//end setOPTB

    public void setOPTC(String oPTC) {
        OPTC = oPTC;
    }//end setOPTC
    public void setTYPE(String tYPE) {
        TYPE = tYPE;
    }//end setTYPE

    public void setANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }//end setANSWER

}//end Question

// @Override
// public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
// getMenuInflater().inflate(R.menu.main, menu);
// return true;
// }

