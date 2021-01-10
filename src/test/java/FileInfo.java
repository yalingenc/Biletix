import java.io.BufferedWriter;

public class FileInfo {

    public void writer(String[] eventName, String[] eventStatus, String[] eventDate){

        try {
            java.io.FileWriter fstream = new java.io.FileWriter("/home/ygenc/Biletix",true);
            BufferedWriter pw = new BufferedWriter(fstream);
            pw.write("---------------------------------------------------" + "\n");
            for (int i=0; i<10; i++){
                pw.write(eventName[i] + " ");
                pw.write(eventStatus[i] + " ");
                pw.write(eventDate[i]);
                pw.newLine();
            }
            pw.close();
        }catch (Exception e){
            System.out.println("Writing File Procces is Failed");
        }


    }

}
