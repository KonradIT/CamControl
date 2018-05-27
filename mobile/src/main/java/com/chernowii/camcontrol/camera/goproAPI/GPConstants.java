package com.chernowii.camcontrol.camera.goproAPI;


import java.net.URI;

/**
 * Created by konrad on 1/2/17.
 */

public class GPConstants {
    public static String settingsUri(String param, String val) {
        return "http://10.5.5.9/gp/gpControl/setting/" + param + "/" + val;
    }
    public static String commandUri(String param) {
        return "http://10.5.5.9/gp/gpControl/command/" + param;
    }
    public static String executeUri(String param) {
        return "http://10.5.5.9/gp/gpControl/execute" + param;
    }
    public static class Commands {
    public static class Stream{
        public static URI Restart = URI.create(executeUri("?p1=gpStream&a1=proto_v2&c1=restart"));
    }
    public static class Shutter {
        public static URI shutter = URI.create(commandUri("shutter?p=1"));
        public static URI stop = URI.create(commandUri("shutter?p=0"));
        public static URI hilight = URI.create(commandUri("storage/tag_moment"));
    }

    public static class Modes {
        public static URI videoMode = URI.create(commandUri("mode?p=0"));
        public static URI photoMode = URI.create(commandUri("mode?p=1"));
        public static URI multishotMode = URI.create(commandUri("mode?p=2"));
        public static class videoSubModes {
            public static URI Video = URI.create(commandUri("sub_mode?mode=0&sub_mode=0"));
            public static URI TimeLapseVideo = URI.create(commandUri("sub_mode?mode=0&sub_mode=1"));
            public static URI VideoPlusPhoto = URI.create(commandUri("sub_mode?mode=0&sub_mode=2"));
            public static URI Looping = URI.create(commandUri("sub_mode?mode=0&sub_mode=3"));
        }

        public static class photoSubModes {
            public static URI Single = URI.create(commandUri("sub_mode?mode=1&sub_mode=0"));
            public static URI Continuous = URI.create(commandUri("sub_mode?mode=1&sub_mode=1"));
            public static URI Night = URI.create(commandUri("sub_mode?mode=1&sub_mode=2"));
        }

        public static class multiShotSubModes {
            public static URI Burst = URI.create(commandUri("sub_mode?mode=2&sub_mode=0"));
            public static URI Timelapse = URI.create(commandUri("sub_mode?mode=2&sub_mode=1"));
            public static URI NightLapse = URI.create(commandUri("sub_mode?mode=2&sub_mode=2"));
        }
    }


}
    public static class Setup {
        public static class Orientation {
            public static URI Up = URI.create(settingsUri("52", "1"));
            public static URI Down = URI.create(settingsUri("52", "2"));
            public static URI Auto = URI.create(settingsUri("52", "0"));
        }

        public static class Locate {

            public static URI On = URI.create(commandUri("system/locate?p=1"));
            public static URI Off = URI.create(commandUri("system/locate?p=0"));

        }

        public static class Delete {
            public static URI DeleteFile = URI.create(commandUri("storage/delete?p=file"));
            public static URI DeleteLast = URI.create(commandUri("storage/delete/last"));
            public static URI Format = URI.create(commandUri("storage/delete/all"));
        }

        public static class QuickCapture {
            public static URI On = URI.create(settingsUri("54", "1"));
            public static URI Off = URI.create(settingsUri("54", "0"));

        }

        public static class LEDBlink {
            public static URI Two = URI.create(settingsUri("55", "1"));
            public static URI Four = URI.create(settingsUri("55", "2"));
            public static URI Off = URI.create(settingsUri("55", "0"));

        }

        public static class Beeps {
            public static URI Off = URI.create(settingsUri("56", "2"));
            public static URI SeventyPercent = URI.create(settingsUri("56", "1"));
            public static URI Full = URI.create(settingsUri("56", "0"));

        }

        public static class VideoFormat {
            public static URI NTSC = URI.create(settingsUri("57", "0"));
            public static URI PAL = URI.create(settingsUri("57", "1"));

        }

        public static class LCDDisplay {
            public static URI On = URI.create(settingsUri("72", "1"));
            public static URI Off = URI.create(settingsUri("72", "0"));

        }

        public static class OnScreenDisplay {
            public static URI On = URI.create(settingsUri("58", "1"));
            public static URI Off = URI.create(settingsUri("58", "0"));

        }

        public static class LCDBrightness {
            public static URI High = URI.create(settingsUri("49", "0"));
            public static URI Medium = URI.create(settingsUri("49", "1"));
            public static URI Low = URI.create(settingsUri("49", "2"));

        }

        public static class LCDLock {
            public static URI On = URI.create(settingsUri("50", "1"));
            public static URI Off = URI.create(settingsUri("50", "0"));

        }

        public static class LCDTimeout {

            public static URI Never = URI.create(settingsUri("51", "0"));
            public static URI LCD1min = URI.create(settingsUri("51", "1"));
            public static URI LCD2min = URI.create(settingsUri("51", "2"));
            public static URI LCD3min = URI.create(settingsUri("51", "3"));

        }

        public static class AutoOff {
            public static URI Never = URI.create(settingsUri("59", "0"));
            public static URI AO1m = URI.create(settingsUri("59", "1"));
            public static URI AO2m = URI.create(settingsUri("59", "2"));
            public static URI AO3m = URI.create(settingsUri("59", "3"));
            public static URI AO5m = URI.create(settingsUri("59", "4"));

        }
    }
    public static class Video{
        public static class Resolutions {
            public static URI Res4K= URI.create(settingsUri("2","1"));
            public static URI Res4K_SuperView= URI.create(settingsUri("2","2"));
            public static URI Res2point7K= URI.create(settingsUri("2","4"));
            public static URI Res2point7KSuperView= URI.create(settingsUri("2","5"));
            public static URI Res2point7K_4by3AR= URI.create(settingsUri("2","6"));
            public static URI Res1440p= URI.create(settingsUri("2","7"));
            public static URI Res1080pSuperView= URI.create(settingsUri("2","8"));
            public static URI Res1080p= URI.create(settingsUri("2","9"));
            public static URI Res960p= URI.create(settingsUri("2","10"));
            public static URI Res720pSuperView= URI.create(settingsUri("2","11"));
            public static URI Res720p= URI.create(settingsUri("2","12"));
            public static URI ResWVGA= URI.create(settingsUri("2","13"));
        }
        public static class FrameRate {
            public static URI FR240fps= URI.create(settingsUri("3","0"));
            public static URI FR120fps= URI.create(settingsUri("3","1"));
            public static URI FR100fps= URI.create(settingsUri("3","2"));
            public static URI FR60fps= URI.create(settingsUri("3","5"));
            public static URI FR50fps= URI.create(settingsUri("3","6"));
            public static URI FR48fps= URI.create(settingsUri("3","7"));
            public static URI FR30fps= URI.create(settingsUri("3","8"));
            public static URI FR25fps= URI.create(settingsUri("3","9"));
            public static URI FR24fps= URI.create(settingsUri("3","10"));
            public static URI FR15fps= URI.create(settingsUri("3","11"));
            public static URI FR12point5fps= URI.create(settingsUri("3","12"));
        }
        public static class FOV {

            public static URI Wide= URI.create(settingsUri("4","0"));
            public static URI Medium= URI.create(settingsUri("4","1"));
            public static URI Narrow= URI.create(settingsUri("4","2"));
            public static URI Linear= URI.create(settingsUri("4","4"));
        }
        public static class LowLight{
            public static URI On= URI.create(settingsUri("8","1"));
            public static URI Off= URI.create(settingsUri("8","0"));
        }
        public static class LoopingDuration{

            public static URI Max= URI.create(settingsUri("6","0"));
            public static URI Loop5Min= URI.create(settingsUri("6","1"));
            public static URI Loop20Min= URI.create(settingsUri("6","2"));
            public static URI Loop60Min= URI.create(settingsUri("6","3"));
            public static URI Loop120Min= URI.create(settingsUri("6","4"));
        }
        public static class VideoPlusPhotoInterval{

            public static URI Interval5Min= URI.create(settingsUri("7","1"));
            public static URI Interval10Min= URI.create(settingsUri("7","2"));
            public static URI Interval30Min= URI.create(settingsUri("7","3"));
            public static URI Interval60Min= URI.create(settingsUri("7","4"));
        }
        public static class SpotMeter {

            public static URI Off = URI.create(settingsUri("9", "0"));
            public static URI On = URI.create(settingsUri("9", "1"));
        }
        public static class ProTune{
            public static URI On = URI.create(settingsUri("10","1"));
            public static URI Off = URI.create(settingsUri("10","0"));
        }
        public static class WhiteBalance{

            public static URI WBAuto = URI.create(settingsUri("11","0"));
            public static URI WB3000k = URI.create(settingsUri("11","1"));
            public static URI WB4000k = URI.create(settingsUri("11","5"));
            public static URI WB4800k = URI.create(settingsUri("11","6"));
            public static URI WB5500k = URI.create(settingsUri("11","2"));
            public static URI WB6000k = URI.create(settingsUri("11","7"));
            public static URI WB6500k = URI.create(settingsUri("11","3"));
            public static URI WBNative = URI.create(settingsUri("11","4"));
        }
        public static class Color{

            public static URI GOPRO = URI.create(settingsUri("12","0"));
            public static URI Flat = URI.create(settingsUri("12","1"));
        }
        public static class ISOLimit{
            public static URI ISO6400 = URI.create(settingsUri("13","0"));
            public static URI ISO1600 = URI.create(settingsUri("13","1"));
            public static URI ISO400 = URI.create(settingsUri("13","2"));
            public static URI ISO3200 = URI.create(settingsUri("13","3"));
            public static URI ISO800 = URI.create(settingsUri("13","4"));
            public static URI ISO200 = URI.create(settingsUri("13","7"));
            public static URI ISO100 = URI.create(settingsUri("13","8"));
        }
        public static class ISOMode{
            public static URI Max = URI.create(settingsUri("74","0"));
            public static URI Lock = URI.create(settingsUri("74","1"));
        }
        public static class Sharpness{
            public static URI High = URI.create(settingsUri("14","0"));
            public static URI Med = URI.create(settingsUri("14","1"));
            public static URI Low = URI.create(settingsUri("14","2"));
        }
        public static class ManualVideoExposure{
            public static URI MVE_AutoMode = URI.create(settingsUri("73","0"));
            public static class FR24FPS{
                public static URI MVE_1_24 = URI.create(settingsUri("73","3"));
                public static URI MVE_1_48 = URI.create(settingsUri("73","6"));
                public static URI MVE_1_96 = URI.create(settingsUri("73","11"));
            }
            public static class FR30FPS{
                public static URI MVE_1_30 = URI.create(settingsUri("73","5"));
                public static URI MVE_1_60 = URI.create(settingsUri("73","8"));
                public static URI MVE_1_120 = URI.create(settingsUri("73","13"));
            }
            public static class FR48FPS{
                public static URI MVE_1_48 = URI.create(settingsUri("73","6"));
                public static URI MVE_1_96 = URI.create(settingsUri("73","11"));
                public static URI MVE_1_192 = URI.create(settingsUri("73","16"));
            }
            public static class FR60FPS{
                public static URI MVE_1_60 = URI.create(settingsUri("73","8"));
                public static URI MVE_1_120 = URI.create(settingsUri("73","13"));
                public static URI MVE_1_240 = URI.create(settingsUri("73","18"));
            }
            public static class FR90FPS{
                public static URI MVE_1_90 = URI.create(settingsUri("73","10"));
                public static URI MVE_1_180 = URI.create(settingsUri("73","15"));
                public static URI MVE_1_360 = URI.create(settingsUri("73","20"));
            }
            public static class FR120FPS{
                public static URI MVE_1_120 = URI.create(settingsUri("73","13"));
                public static URI MVE_1_240 = URI.create(settingsUri("73","18"));
                public static URI MVE_1_480 = URI.create(settingsUri("73","22"));
            }
            public static class FR240FPS{
                public static URI MVE_1_120 = URI.create(settingsUri("73","18"));
                public static URI MVE_1_240 = URI.create(settingsUri("73","22"));
                public static URI MVE_1_480 = URI.create(settingsUri("73","23"));

            }
        }
        public static class EVComp{
            static String param="15";
            public static URI EVMinus2_0 = URI.create(settingsUri(param,"8"));
            public static URI EVMinus1_5 = URI.create(settingsUri(param,"7"));
            public static URI EVMinus1_0 = URI.create(settingsUri(param,"6"));
            public static URI EVMinus0_5 = URI.create(settingsUri(param,"5"));
            public static URI EV0_0 = URI.create(settingsUri(param,"4"));
            public static URI EV0_5 = URI.create(settingsUri(param,"3"));
            public static URI EV1_0 = URI.create(settingsUri(param,"2"));
            public static URI EV1_5 = URI.create(settingsUri(param,"1"));
            public static URI EV2_0 = URI.create(settingsUri(param,"0"));

        }
    }

    public static class Photo{

        public static class ContinuousRate{
            static String param="18";
            public static URI C3PPS = URI.create(settingsUri(param,"0"));
            public static URI C5PPS = URI.create(settingsUri(param,"1"));
            public static URI C10PPS = URI.create(settingsUri(param,"2"));

        }

        public static class Resolution{
            static String param="17";
            public static URI R12MPW = URI.create(settingsUri(param,"0"));
            public static URI R12MPL= URI.create(settingsUri(param,"10"));
            public static URI R12MPM= URI.create(settingsUri(param,"8"));
            public static URI R12MPN= URI.create(settingsUri(param,"9"));
            public static URI R10MPW= URI.create(settingsUri(param,"4"));
            public static URI R10MPL= URI.create(settingsUri(param,"11"));
            public static URI R8MPW = URI.create(settingsUri(param,"0"));
            public static URI R7MPW = URI.create(settingsUri(param,"1"));
            public static URI R7MPM = URI.create(settingsUri(param,"2"));
            public static URI R5MPM = URI.create(settingsUri(param,"3"));

        }
        public static class Shutter{
            static String param="19";
            public static URI ShutterAuto = URI.create(settingsUri(param,"0"));
            public static URI Shutter2S = URI.create(settingsUri(param,"1"));
            public static URI Shutter5S = URI.create(settingsUri(param,"2"));
            public static URI Shutter10S = URI.create(settingsUri(param,"3"));
            public static URI Shutter15S = URI.create(settingsUri(param,"4"));
            public static URI Shutter20S = URI.create(settingsUri(param,"5"));
            public static URI Shutter30S = URI.create(settingsUri(param,"6"));

        }
        public static class SpotMeter{
            static String param="20";
            public static URI ON = URI.create(settingsUri(param,"1"));
            public static URI OFF = URI.create(settingsUri(param,"0"));

        }
        public static class WDR{
            static String param="77";
            public static URI ON = URI.create(settingsUri(param,"1"));
            public static URI OFF = URI.create(settingsUri(param,"0"));

        }
        public static class RAW{
            static String param="82";
            public static URI ON = URI.create(settingsUri(param,"1"));
            public static URI OFF = URI.create(settingsUri(param,"0"));

        }
        public static class Protune{
            static String param="21";
            public static URI ON = URI.create(settingsUri(param,"1"));
            public static URI OFF = URI.create(settingsUri(param,"0"));

        }
        public static class WhiteBalance{
            static String param="22";
            public static URI WBAuto = URI.create(settingsUri(param,"0"));
            public static URI WB3000K = URI.create(settingsUri(param,"1"));
            public static URI WB4000K = URI.create(settingsUri(param,"5"));
            public static URI WB4800K = URI.create(settingsUri(param,"6"));
            public static URI WB5500K = URI.create(settingsUri(param,"2"));
            public static URI WB6000K = URI.create(settingsUri(param,"7"));
            public static URI WB6500K = URI.create(settingsUri(param,"3"));
            public static URI WBNative = URI.create(settingsUri(param,"4"));

        }
        public static class Color{
            static String param="23";
            public static URI GoProColor = URI.create(settingsUri(param,"0"));
            public static URI Flat = URI.create(settingsUri(param,"1"));

        }
        public static class Sharpness{
            static String param="25";
            public static URI High = URI.create(settingsUri(param,"0"));
            public static URI Medium = URI.create(settingsUri(param,"1"));
            public static URI Low = URI.create(settingsUri(param,"2"));

        }
        public static class EVComp{
            static String param="26";
            public static URI EVMinus2_0 = URI.create(settingsUri(param,"8"));
            public static URI EVMinus1_5 = URI.create(settingsUri(param,"7"));
            public static URI EVMinus1_0 = URI.create(settingsUri(param,"6"));
            public static URI EVMinus0_5 = URI.create(settingsUri(param,"5"));
            public static URI EV0_0 = URI.create(settingsUri(param,"4"));
            public static URI EV0_5 = URI.create(settingsUri(param,"3"));
            public static URI EV1_0 = URI.create(settingsUri(param,"2"));
            public static URI EV1_5 = URI.create(settingsUri(param,"1"));
            public static URI EV2_0 = URI.create(settingsUri(param,"0"));

        }
        public static class ISOMin{
            static String param="75";
            public static URI ISO800 = URI.create(settingsUri(param,"0"));
            public static URI ISO400 = URI.create(settingsUri(param,"1"));
            public static URI ISO200 = URI.create(settingsUri(param,"2"));
            public static URI ISO100 = URI.create(settingsUri(param,"3"));

        }
        public static class ISOMax{
            static String param="24";
            public static URI ISO800 = URI.create(settingsUri(param,"0"));
            public static URI ISO400 = URI.create(settingsUri(param,"1"));
            public static URI ISO200 = URI.create(settingsUri(param,"2"));
            public static URI ISO100 = URI.create(settingsUri(param,"3"));
        }
    }
}
