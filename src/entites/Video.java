/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import com.xuggle.xuggler.IContainer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guezel
 */
public class Video extends FileExtended {

    private static final List<String> VIDEO_EXTENSION_LIST = new ArrayList() {{
        add("mkv");
        add("mp4");
        add("avi");
        add("wmv");
        add("mov");
        add("mpg");
    }};
    private long duration;
    
    public Video(File f) throws IOException {
        super(f);
        this.duration = duration();
        
    }
    /**
     * 
     * @return true if the extension is included in VIDEO_EXTENSION_LIST
     */
    private boolean isVideo() {
        return VIDEO_EXTENSION_LIST.stream().anyMatch((s) -> (this.getExtension().equals(s)));
    }

    /**
     * @return the duration
     */
    public long getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }
    
    public long duration() {
        IContainer icontainer = IContainer.make();
        int res = icontainer.open(this.getPath(), IContainer.Type.READ, null);
        if(res>=0)
        {
            return icontainer.getDuration();
        }
        else
        {
            return -1;
        }
    }
}
