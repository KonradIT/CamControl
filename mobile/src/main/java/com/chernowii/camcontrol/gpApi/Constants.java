package com.chernowii.camcontrol.gpApi;


import java.net.URI;

/**
 * Created by konrad on 1/2/17.
 */

public class Constants {
    public static String gpControlUri(String param, String val){
        return "http://10.5.5.9/gp/gpControl/setting/" + param + "/" + val;
    }
    public static class Shutter {
        public static URI shutter = URI.create("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
        public static URI stop = URI.create("http://10.5.5.9/gp/gpControl/command/shutter?p=0");
        public static URI hilight = URI.create("http://10.5.5.9/gp/gpControl/command/storage/tag_moment");
    }
    public static class cameraModes {
        public static URI videoMode = URI.create("http://10.5.5.9/gp/gpControl/command/mode?p=0");
        public static URI photoMode = URI.create("http://10.5.5.9/gp/gpControl/command/mode?p=1");
        public static URI multishotMode = URI.create("http://10.5.5.9/gp/gpControl/command/mode?p=2");
    }
    public static class videoSubModes {
        public static URI Video = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=0&sub_mode=0");
        public static URI TimeLapseVideo = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=0&sub_mode=1");
        public static URI VideoPlusPhoto = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=0&sub_mode=2");
        public static URI Looping = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=0&sub_mode=3");
    }
    public static class photoSubModes {
        public static URI Single = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=1&sub_mode=0");
        public static URI Continuous = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=1&sub_mode=1");
        public static URI Night = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=1&sub_mode=2");
    }
    public static class multiShotSubModes {
        public static URI Burst = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=2&sub_mode=0");
        public static URI Timelapse = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=2&sub_mode=1");
        public static URI NightLapse = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=2&sub_mode=2");
    }
    public static class Setup {
        public static class Orientation {
            public static URI Up = URI.create(gpControlUri("52", "1"));
            public static URI Down = URI.create(gpControlUri("52", "2"));
            public static URI Auto = URI.create(gpControlUri("52", "0"));
        }

        public static class Locate {

            public static URI On = URI.create("http://10.5.5.9/gp/gpControl/command/system/locate?p=1");
            public static URI Off = URI.create("http://10.5.5.9/gp/gpControl/command/system/locate?p=0");

        }

        public static class Delete {
            public static URI DeleteFile = URI.create("//10.5.5.9/gp/gpControl/command/storage/delete?p=file");
            public static URI DeleteLast = URI.create("//10.5.5.9/gp/gpControl/command/storage/delete/last");
            public static URI Format = URI.create("//10.5.5.9/gp/gpControl/command/storage/delete/all");
        }

        public static class QuickCapture {
            public static URI On = URI.create(gpControlUri("54", "1"));
            public static URI Off = URI.create(gpControlUri("54", "0"));

        }

        public static class LEDBlink {
            public static URI Two = URI.create(gpControlUri("55", "1"));
            public static URI Four = URI.create(gpControlUri("55", "2"));
            public static URI Off = URI.create(gpControlUri("55", "0"));

        }

        public static class Beeps {
            public static URI Off = URI.create(gpControlUri("56", "2"));
            public static URI SeventyPercent = URI.create(gpControlUri("56", "1"));
            public static URI Full = URI.create(gpControlUri("56", "0"));

        }

        public static class VideoFormat {
            public static URI NTSC = URI.create(gpControlUri("57", "0"));
            public static URI PAL = URI.create(gpControlUri("57", "1"));

        }

        public static class LCDDisplay {
            public static URI On = URI.create(gpControlUri("72", "1"));
            public static URI Off = URI.create(gpControlUri("72", "0"));

        }

        public static class OnScreenDisplay {
            public static URI On = URI.create(gpControlUri("58", "1"));
            public static URI Off = URI.create(gpControlUri("58", "0"));

        }

        public static class LCDBrightness {
            public static URI High = URI.create(gpControlUri("49", "0"));
            public static URI Medium = URI.create(gpControlUri("49", "1"));
            public static URI Low = URI.create(gpControlUri("49", "2"));

        }

        public static class LCDLock {
            public static URI On = URI.create(gpControlUri("50", "1"));
            public static URI Off = URI.create(gpControlUri("50", "0"));

        }

        public static class LCDTimeout {

            public static URI Never = URI.create(gpControlUri("51", "0"));
            public static URI LCD1min = URI.create(gpControlUri("51", "1"));
            public static URI LCD2min = URI.create(gpControlUri("51", "2"));
            public static URI LCD3min = URI.create(gpControlUri("51", "3"));

        }

        public static class AutoOff {
            public static URI Never = URI.create(gpControlUri("59", "0"));
            public static URI AO1m = URI.create(gpControlUri("59", "1"));
            public static URI AO2m = URI.create(gpControlUri("59", "2"));
            public static URI AO3m = URI.create(gpControlUri("59", "3"));
            public static URI AO5m = URI.create(gpControlUri("59", "4"));

        }
    }
}
