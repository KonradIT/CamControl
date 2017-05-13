package com.chernowii.camcontrol.camera.sonyAPI;


import java.net.URI;

/**
 * Created by konrad on 1/2/17.
 */

public class Constants {
    public static String baseUri(String param, String val){
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
            public static URI Up = URI.create(baseUri("52", "1"));
            public static URI Down = URI.create(baseUri("52", "2"));
            public static URI Auto = URI.create(baseUri("52", "0"));
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
            public static URI On = URI.create(baseUri("54", "1"));
            public static URI Off = URI.create(baseUri("54", "0"));

        }

        public static class LEDBlink {
            public static URI Two = URI.create(baseUri("55", "1"));
            public static URI Four = URI.create(baseUri("55", "2"));
            public static URI Off = URI.create(baseUri("55", "0"));

        }

        public static class Beeps {
            public static URI Off = URI.create(baseUri("56", "2"));
            public static URI SeventyPercent = URI.create(baseUri("56", "1"));
            public static URI Full = URI.create(baseUri("56", "0"));

        }

        public static class VideoFormat {
            public static URI NTSC = URI.create(baseUri("57", "0"));
            public static URI PAL = URI.create(baseUri("57", "1"));

        }

        public static class LCDDisplay {
            public static URI On = URI.create(baseUri("72", "1"));
            public static URI Off = URI.create(baseUri("72", "0"));

        }

        public static class OnScreenDisplay {
            public static URI On = URI.create(baseUri("58", "1"));
            public static URI Off = URI.create(baseUri("58", "0"));

        }

        public static class LCDBrightness {
            public static URI High = URI.create(baseUri("49", "0"));
            public static URI Medium = URI.create(baseUri("49", "1"));
            public static URI Low = URI.create(baseUri("49", "2"));

        }

        public static class LCDLock {
            public static URI On = URI.create(baseUri("50", "1"));
            public static URI Off = URI.create(baseUri("50", "0"));

        }

        public static class LCDTimeout {

            public static URI Never = URI.create(baseUri("51", "0"));
            public static URI LCD1min = URI.create(baseUri("51", "1"));
            public static URI LCD2min = URI.create(baseUri("51", "2"));
            public static URI LCD3min = URI.create(baseUri("51", "3"));

        }

        public static class AutoOff {
            public static URI Never = URI.create(baseUri("59", "0"));
            public static URI AO1m = URI.create(baseUri("59", "1"));
            public static URI AO2m = URI.create(baseUri("59", "2"));
            public static URI AO3m = URI.create(baseUri("59", "3"));
            public static URI AO5m = URI.create(baseUri("59", "4"));

        }
    }
    public static class Video{
        public static class Resolutions {
            public static URI Res4K= URI.create(baseUri("2","1"));
            public static URI Res4K_SuperView= URI.create(baseUri("2","2"));
            public static URI Res2point7K= URI.create(baseUri("2","4"));
            public static URI Res2point7KSuperView= URI.create(baseUri("2","5"));
            public static URI Res2point7K_4by3AR= URI.create(baseUri("2","6"));
            public static URI Res1440p= URI.create(baseUri("2","7"));
            public static URI Res1080pSuperView= URI.create(baseUri("2","8"));
            public static URI Res1080p= URI.create(baseUri("2","9"));
            public static URI Res960p= URI.create(baseUri("2","10"));
            public static URI Res720pSuperView= URI.create(baseUri("2","11"));
            public static URI Res720p= URI.create(baseUri("2","12"));
            public static URI ResWVGA= URI.create(baseUri("2","13"));
        }
        public static class FrameRate {
            public static URI FR240fps= URI.create(baseUri("3","0"));
            public static URI FR120fps= URI.create(baseUri("3","1"));
            public static URI FR100fps= URI.create(baseUri("3","2"));
            public static URI FR60fps= URI.create(baseUri("3","5"));
            public static URI FR50fps= URI.create(baseUri("3","6"));
            public static URI FR48fps= URI.create(baseUri("3","7"));
            public static URI FR30fps= URI.create(baseUri("3","8"));
            public static URI FR25fps= URI.create(baseUri("3","9"));
            public static URI FR24fps= URI.create(baseUri("3","10"));
            public static URI FR15fps= URI.create(baseUri("3","11"));
            public static URI FR12point5fps= URI.create(baseUri("3","12"));
        }
        public static class FOV {

            public static URI Wide= URI.create(baseUri("4","0"));
            public static URI Medium= URI.create(baseUri("4","1"));
            public static URI Narrow= URI.create(baseUri("4","2"));
            public static URI Linear= URI.create(baseUri("4","4"));
        }
        public static class LowLight{
            public static URI On= URI.create(baseUri("8","1"));
            public static URI Off= URI.create(baseUri("8","0"));
        }
        public static class LoopingDuration{

            public static URI Max= URI.create(baseUri("6","0"));
            public static URI Loop5Min= URI.create(baseUri("6","1"));
            public static URI Loop20Min= URI.create(baseUri("6","2"));
            public static URI Loop60Min= URI.create(baseUri("6","3"));
            public static URI Loop120Min= URI.create(baseUri("6","4"));
        }
        public static class VideoPlusPhotoInterval{

            public static URI Interval5Min= URI.create(baseUri("7","1"));
            public static URI Interval10Min= URI.create(baseUri("7","2"));
            public static URI Interval30Min= URI.create(baseUri("7","3"));
            public static URI Interval60Min= URI.create(baseUri("7","4"));
        }
        public static class SpotMeter {

            public static URI Off = URI.create(baseUri("9", "0"));
            public static URI On = URI.create(baseUri("9", "1"));
        }
        public static class ProTune{
            public static URI On = URI.create(baseUri("10","1"));
            public static URI Off = URI.create(baseUri("10","0"));
        }
        public static class WhiteBalance{

            public static URI WBAuto = URI.create(baseUri("11","0"));
            public static URI WB3000k = URI.create(baseUri("11","1"));
            public static URI WB4000k = URI.create(baseUri("11","5"));
            public static URI WB4800k = URI.create(baseUri("11","6"));
            public static URI WB5500k = URI.create(baseUri("11","2"));
            public static URI WB6000k = URI.create(baseUri("11","7"));
            public static URI WB6500k = URI.create(baseUri("11","3"));
            public static URI WBNative = URI.create(baseUri("11","4"));
        }
        public static class Color{

            public static URI GOPRO = URI.create(baseUri("12","0"));
            public static URI Flat = URI.create(baseUri("12","1"));
        }
        public static class ISOLimit{
            public static URI ISO6400 = URI.create(baseUri("13","0"));
            public static URI ISO1600 = URI.create(baseUri("13","1"));
            public static URI ISO400 = URI.create(baseUri("13","2"));
            public static URI ISO3200 = URI.create(baseUri("13","3"));
            public static URI ISO800 = URI.create(baseUri("13","4"));
            public static URI ISO200 = URI.create(baseUri("13","7"));
            public static URI ISO100 = URI.create(baseUri("13","8"));
        }
        public static class ISOMode{
            public static URI Max = URI.create(baseUri("74","0"));
            public static URI Lock = URI.create(baseUri("74","1"));
        }
        public static class Sharpness{
            public static URI High = URI.create(baseUri("14","0"));
            public static URI Med = URI.create(baseUri("14","1"));
            public static URI Low = URI.create(baseUri("14","2"));
        }
        public static class ManualVideoExposure{
            public static URI MVE_AutoMode = URI.create(baseUri("73","0"));
            public static class FR24FPS{
                public static URI MVE_1_24 = URI.create(baseUri("73","3"));
                public static URI MVE_1_48 = URI.create(baseUri("73","6"));
                public static URI MVE_1_96 = URI.create(baseUri("73","11"));
            }
            public static class FR30FPS{
                public static URI MVE_1_30 = URI.create(baseUri("73","5"));
                public static URI MVE_1_60 = URI.create(baseUri("73","8"));
                public static URI MVE_1_120 = URI.create(baseUri("73","13"));
            }
            public static class FR48FPS{
                public static URI MVE_1_48 = URI.create(baseUri("73","6"));
                public static URI MVE_1_96 = URI.create(baseUri("73","11"));
                public static URI MVE_1_192 = URI.create(baseUri("73","16"));
            }
            public static class FR60FPS{
                public static URI MVE_1_60 = URI.create(baseUri("73","8"));
                public static URI MVE_1_120 = URI.create(baseUri("73","13"));
                public static URI MVE_1_240 = URI.create(baseUri("73","18"));
            }
            public static class FR90FPS{
                public static URI MVE_1_90 = URI.create(baseUri("73","10"));
                public static URI MVE_1_180 = URI.create(baseUri("73","15"));
                public static URI MVE_1_360 = URI.create(baseUri("73","20"));
            }
            public static class FR120FPS{
                public static URI MVE_1_120 = URI.create(baseUri("73","13"));
                public static URI MVE_1_240 = URI.create(baseUri("73","18"));
                public static URI MVE_1_480 = URI.create(baseUri("73","22"));
            }
            public static class FR240FPS{
                public static URI MVE_1_120 = URI.create(baseUri("73","18"));
                public static URI MVE_1_240 = URI.create(baseUri("73","22"));
                public static URI MVE_1_480 = URI.create(baseUri("73","23"));

            }
        }
    }

    public static class Photo{

    }
}
