package reproductor_de_musica;

import java.io.PrintStream;
import java.util.Map;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

public class Zplayer implements BasicPlayerListener {

    BasicPlayer player = new BasicPlayer();
    PrintStream out;
    BasicController control = (BasicController) player;
    float[] equalizador;
    float[] eq = new float[32]; 

    public Zplayer() {
        player.addBasicPlayerListener(this);
        out = System.out;
    }

    public void opened(Object o, Map properties) {
        display("opened : " + properties.toString());
    }

    public void progress(int i, long l, byte[] bytes, Map properties) {
        equalizador = (float[]) properties.get("mp3.equalizer");
        System.arraycopy(eq, 0, equalizador, 0, equalizador.length);
        display("progress : " + properties.toString()); 
    }

    public void stateUpdated(BasicPlayerEvent event) {
        display("stateUpdated : " + event.toString()); 
    }

    public void setController(BasicController controller) {
        display("setController : " + controller); 
    }

    public void display(String msg) {
        if (out != null) {
//            out.println(msg);
        }
    }
}
