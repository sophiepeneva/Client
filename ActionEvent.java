# Client
for my upload/download server

public class ActionEvent {
    byte[] filename;

    public byte[] getFilename() {
        return filename;
    }

    public void setFilename(byte[] filename) {
        if (filename == null){
            return;
        }
        this.filename = new byte[filename.length];
        for (int i = 0; i < filename.length; i++) {
            this.filename[i] = filename[i];
        }
    }

    public ActionEvent(byte[] filename){
        setFilename(filename);
    }
}
