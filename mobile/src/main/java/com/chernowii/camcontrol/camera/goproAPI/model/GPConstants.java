package com.chernowii.camcontrol.camera.goproAPI.model;


import com.chernowii.camcontrol.camera.goproAPI.ApiBase;
import com.chernowii.camcontrol.camera.goproAPI.ApiClient;

import java.net.URI;

import retrofit2.Call;

/**
 * Created by konrad on 1/2/17.
 */

public class GPConstants {
    static ApiClient GoProApi = ApiBase.getMainClient().create(ApiClient.class);
    public static class Commands {
    public static class Stream{
        public static Call<GoProResponse> Restart = GoProApi.execute("?p1=gpStream&a1=proto_v2&c1=restart");
    }
    public static class Shutter {
        public static Call<GoProResponse> shutter = GoProApi.command("shutter","1");
        public static Call<GoProResponse> stop = GoProApi.command("shutter","0");
        public static Call<GoProResponse> hilight = GoProApi.command("storage/tag_moment","");
    }

    public static class Modes {
        public static Call<GoProResponse> videoMode = GoProApi.command("mode","0");
        public static Call<GoProResponse> photoMode = GoProApi.command("mode","1");
        public static Call<GoProResponse> multishotMode = GoProApi.command("mode","2");
        public static class videoSubModes {
            public static Call<GoProResponse> Video = GoProApi.command("sub_mode","mode=0&sub_mode=0");
            public static Call<GoProResponse> TimeLapseVideo = GoProApi.command("sub_mode","mode=0&sub_mode=1");
            public static Call<GoProResponse> VideoPlusPhoto = GoProApi.command("sub_mode","mode=0&sub_mode=2");
            public static Call<GoProResponse> Looping = GoProApi.command("sub_mode","mode=0&sub_mode=3");
        }

        public static class photoSubModes {
            public static Call<GoProResponse> Single = GoProApi.command("sub_mode","mode=1&sub_mode=0");
            public static Call<GoProResponse> Continuous = GoProApi.command("sub_mode","mode=1&sub_mode=1");
            public static Call<GoProResponse> Night = GoProApi.command("sub_mode","mode=1&sub_mode=2");
        }

        public static class multiShotSubModes {
            public static Call<GoProResponse> Burst = GoProApi.command("sub_mode","mode=2&sub_mode=0");
            public static Call<GoProResponse> Timelapse = GoProApi.command("sub_mode","mode=2&sub_mode=1");
            public static Call<GoProResponse> NightLapse = GoProApi.command("sub_mode","mode=2&sub_mode=2");
        }
    }


}
    public static class Setup {
        public static class Orientation {
            public static Call<GoProResponse> Up = GoProApi.config("52", "1");
            public static Call<GoProResponse> Down = GoProApi.config("52", "2");
            public static Call<GoProResponse> Auto = GoProApi.config("52", "0");
        }

        public static class Locate {

            public static Call<GoProResponse> On = GoProApi.command("system/locate","1");
            public static Call<GoProResponse> Off = GoProApi.command("system/locate","0");

        }

        public static class Delete {
            public static Call<GoProResponse> DeleteFile = GoProApi.command("storage/delete","file");
            public static Call<GoProResponse> DeleteLast = GoProApi.command("storage/delete/last","");
            public static Call<GoProResponse> Format = GoProApi.command("storage/delete/all","");
        }

        public static class QuickCapture {
            public static Call<GoProResponse> On = GoProApi.config("54", "1");
            public static Call<GoProResponse> Off = GoProApi.config("54", "0");

        }

        public static class LEDBlink {
            public static Call<GoProResponse> Two = GoProApi.config("55", "1");
            public static Call<GoProResponse> Four = GoProApi.config("55", "2");
            public static Call<GoProResponse> Off = GoProApi.config("55", "0");

        }

        public static class Beeps {
            public static Call<GoProResponse> Off = GoProApi.config("56", "2");
            public static Call<GoProResponse> SeventyPercent = GoProApi.config("56", "1");
            public static Call<GoProResponse> Full = GoProApi.config("56", "0");

        }

        public static class VideoFormat {
            public static Call<GoProResponse> NTSC = GoProApi.config("57", "0");
            public static Call<GoProResponse> PAL = GoProApi.config("57", "1");

        }

        public static class LCDDisplay {
            public static Call<GoProResponse> On = GoProApi.config("72", "1");
            public static Call<GoProResponse> Off = GoProApi.config("72", "0");

        }

        public static class OnScreenDisplay {
            public static Call<GoProResponse> On = GoProApi.config("58", "1");
            public static Call<GoProResponse> Off = GoProApi.config("58", "0");

        }

        public static class LCDBrightness {
            public static Call<GoProResponse> High = GoProApi.config("49", "0");
            public static Call<GoProResponse> Medium = GoProApi.config("49", "1");
            public static Call<GoProResponse> Low = GoProApi.config("49", "2");

        }

        public static class LCDLock {
            public static Call<GoProResponse> On = GoProApi.config("50", "1");
            public static Call<GoProResponse> Off = GoProApi.config("50", "0");

        }

        public static class LCDTimeout {

            public static Call<GoProResponse> Never = GoProApi.config("51", "0");
            public static Call<GoProResponse> LCD1min = GoProApi.config("51", "1");
            public static Call<GoProResponse> LCD2min = GoProApi.config("51", "2");
            public static Call<GoProResponse> LCD3min = GoProApi.config("51", "3");

        }

        public static class AutoOff {
            public static Call<GoProResponse> Never = GoProApi.config("59", "0");
            public static Call<GoProResponse> AO1m = GoProApi.config("59", "1");
            public static Call<GoProResponse> AO2m = GoProApi.config("59", "2");
            public static Call<GoProResponse> AO3m = GoProApi.config("59", "3");
            public static Call<GoProResponse> AO5m = GoProApi.config("59", "4");

        }
    }
    public static class Video{
        public static class Resolutions {
            public static Call<GoProResponse> Res4K= GoProApi.config("2","1");
            public static Call<GoProResponse> Res4K_SuperView= GoProApi.config("2","2");
            public static Call<GoProResponse> Res2point7K= GoProApi.config("2","4");
            public static Call<GoProResponse> Res2point7KSuperView= GoProApi.config("2","5");
            public static Call<GoProResponse> Res2point7K_4by3AR= GoProApi.config("2","6");
            public static Call<GoProResponse> Res1440p= GoProApi.config("2","7");
            public static Call<GoProResponse> Res1080pSuperView= GoProApi.config("2","8");
            public static Call<GoProResponse> Res1080p= GoProApi.config("2","9");
            public static Call<GoProResponse> Res960p= GoProApi.config("2","10");
            public static Call<GoProResponse> Res720pSuperView= GoProApi.config("2","11");
            public static Call<GoProResponse> Res720p= GoProApi.config("2","12");
            public static Call<GoProResponse> ResWVGA= GoProApi.config("2","13");
        }
        public static class FrameRate {
            public static Call<GoProResponse> FR240fps= GoProApi.config("3","0");
            public static Call<GoProResponse> FR120fps= GoProApi.config("3","1");
            public static Call<GoProResponse> FR100fps= GoProApi.config("3","2");
            public static Call<GoProResponse> FR60fps= GoProApi.config("3","5");
            public static Call<GoProResponse> FR50fps= GoProApi.config("3","6");
            public static Call<GoProResponse> FR48fps= GoProApi.config("3","7");
            public static Call<GoProResponse> FR30fps= GoProApi.config("3","8");
            public static Call<GoProResponse> FR25fps= GoProApi.config("3","9");
            public static Call<GoProResponse> FR24fps= GoProApi.config("3","10");
            public static Call<GoProResponse> FR15fps= GoProApi.config("3","11");
            public static Call<GoProResponse> FR12point5fps= GoProApi.config("3","12");
        }
        public static class FOV {

            public static Call<GoProResponse> Wide= GoProApi.config("4","0");
            public static Call<GoProResponse> Medium= GoProApi.config("4","1");
            public static Call<GoProResponse> Narrow= GoProApi.config("4","2");
            public static Call<GoProResponse> Linear= GoProApi.config("4","4");
        }
        public static class LowLight{
            public static Call<GoProResponse> On= GoProApi.config("8","1");
            public static Call<GoProResponse> Off= GoProApi.config("8","0");
        }
        public static class LoopingDuration{

            public static Call<GoProResponse> Max= GoProApi.config("6","0");
            public static Call<GoProResponse> Loop5Min= GoProApi.config("6","1");
            public static Call<GoProResponse> Loop20Min= GoProApi.config("6","2");
            public static Call<GoProResponse> Loop60Min= GoProApi.config("6","3");
            public static Call<GoProResponse> Loop120Min= GoProApi.config("6","4");
        }
        public static class VideoPlusPhotoInterval{

            public static Call<GoProResponse> Interval5Min= GoProApi.config("7","1");
            public static Call<GoProResponse> Interval10Min= GoProApi.config("7","2");
            public static Call<GoProResponse> Interval30Min= GoProApi.config("7","3");
            public static Call<GoProResponse> Interval60Min= GoProApi.config("7","4");
        }
        public static class SpotMeter {

            public static Call<GoProResponse> Off = GoProApi.config("9", "0");
            public static Call<GoProResponse> On = GoProApi.config("9", "1");
        }
        public static class ProTune{
            public static Call<GoProResponse> On = GoProApi.config("10","1");
            public static Call<GoProResponse> Off = GoProApi.config("10","0");
        }
        public static class WhiteBalance{

            public static Call<GoProResponse> WBAuto = GoProApi.config("11","0");
            public static Call<GoProResponse> WB3000k = GoProApi.config("11","1");
            public static Call<GoProResponse> WB4000k = GoProApi.config("11","5");
            public static Call<GoProResponse> WB4800k = GoProApi.config("11","6");
            public static Call<GoProResponse> WB5500k = GoProApi.config("11","2");
            public static Call<GoProResponse> WB6000k = GoProApi.config("11","7");
            public static Call<GoProResponse> WB6500k = GoProApi.config("11","3");
            public static Call<GoProResponse> WBNative = GoProApi.config("11","4");
        }
        public static class Color{

            public static Call<GoProResponse> GOPRO = GoProApi.config("12","0");
            public static Call<GoProResponse> Flat = GoProApi.config("12","1");
        }
        public static class ISOLimit{
            public static Call<GoProResponse> ISO6400 = GoProApi.config("13","0");
            public static Call<GoProResponse> ISO1600 = GoProApi.config("13","1");
            public static Call<GoProResponse> ISO400 = GoProApi.config("13","2");
            public static Call<GoProResponse> ISO3200 = GoProApi.config("13","3");
            public static Call<GoProResponse> ISO800 = GoProApi.config("13","4");
            public static Call<GoProResponse> ISO200 = GoProApi.config("13","7");
            public static Call<GoProResponse> ISO100 = GoProApi.config("13","8");
        }
        public static class ISOMode{
            public static Call<GoProResponse> Max = GoProApi.config("74","0");
            public static Call<GoProResponse> Lock = GoProApi.config("74","1");
        }
        public static class Sharpness{
            public static Call<GoProResponse> High = GoProApi.config("14","0");
            public static Call<GoProResponse> Med = GoProApi.config("14","1");
            public static Call<GoProResponse> Low = GoProApi.config("14","2");
        }
        public static class ManualVideoExposure{
            public static Call<GoProResponse> MVE_AutoMode = GoProApi.config("73","0");
            public static class FR24FPS{
                public static Call<GoProResponse> MVE_1_24 = GoProApi.config("73","3");
                public static Call<GoProResponse> MVE_1_48 = GoProApi.config("73","6");
                public static Call<GoProResponse> MVE_1_96 = GoProApi.config("73","11");
            }
            public static class FR30FPS{
                public static Call<GoProResponse> MVE_1_30 = GoProApi.config("73","5");
                public static Call<GoProResponse> MVE_1_60 = GoProApi.config("73","8");
                public static Call<GoProResponse> MVE_1_120 = GoProApi.config("73","13");
            }
            public static class FR48FPS{
                public static Call<GoProResponse> MVE_1_48 = GoProApi.config("73","6");
                public static Call<GoProResponse> MVE_1_96 = GoProApi.config("73","11");
                public static Call<GoProResponse> MVE_1_192 = GoProApi.config("73","16");
            }
            public static class FR60FPS{
                public static Call<GoProResponse> MVE_1_60 = GoProApi.config("73","8");
                public static Call<GoProResponse> MVE_1_120 = GoProApi.config("73","13");
                public static Call<GoProResponse> MVE_1_240 = GoProApi.config("73","18");
            }
            public static class FR90FPS{
                public static Call<GoProResponse> MVE_1_90 = GoProApi.config("73","10");
                public static Call<GoProResponse> MVE_1_180 = GoProApi.config("73","15");
                public static Call<GoProResponse> MVE_1_360 = GoProApi.config("73","20");
            }
            public static class FR120FPS{
                public static Call<GoProResponse> MVE_1_120 = GoProApi.config("73","13");
                public static Call<GoProResponse> MVE_1_240 = GoProApi.config("73","18");
                public static Call<GoProResponse> MVE_1_480 = GoProApi.config("73","22");
            }
            public static class FR240FPS{
                public static Call<GoProResponse> MVE_1_120 = GoProApi.config("73","18");
                public static Call<GoProResponse> MVE_1_240 = GoProApi.config("73","22");
                public static Call<GoProResponse> MVE_1_480 = GoProApi.config("73","23");

            }
        }
        public static class EVComp{
            static String param="15";
            public static Call<GoProResponse> EVMinus2_0 = GoProApi.config(param,"8");
            public static Call<GoProResponse> EVMinus1_5 = GoProApi.config(param,"7");
            public static Call<GoProResponse> EVMinus1_0 = GoProApi.config(param,"6");
            public static Call<GoProResponse> EVMinus0_5 = GoProApi.config(param,"5");
            public static Call<GoProResponse> EV0_0 = GoProApi.config(param,"4");
            public static Call<GoProResponse> EV0_5 = GoProApi.config(param,"3");
            public static Call<GoProResponse> EV1_0 = GoProApi.config(param,"2");
            public static Call<GoProResponse> EV1_5 = GoProApi.config(param,"1");
            public static Call<GoProResponse> EV2_0 = GoProApi.config(param,"0");

        }
    }

    public static class Photo{

        public static class ContinuousRate{
            static String param="18";
            public static Call<GoProResponse> C3PPS = GoProApi.config(param,"0");
            public static Call<GoProResponse> C5PPS = GoProApi.config(param,"1");
            public static Call<GoProResponse> C10PPS = GoProApi.config(param,"2");

        }

        public static class Resolution{
            static String param="17";
            public static Call<GoProResponse> R12MPW = GoProApi.config(param,"0");
            public static Call<GoProResponse> R12MPL= GoProApi.config(param,"10");
            public static Call<GoProResponse> R12MPM= GoProApi.config(param,"8");
            public static Call<GoProResponse> R12MPN= GoProApi.config(param,"9");
            public static Call<GoProResponse> R10MPW= GoProApi.config(param,"4");
            public static Call<GoProResponse> R10MPL= GoProApi.config(param,"11");
            public static Call<GoProResponse> R8MPW = GoProApi.config(param,"0");
            public static Call<GoProResponse> R7MPW = GoProApi.config(param,"1");
            public static Call<GoProResponse> R7MPM = GoProApi.config(param,"2");
            public static Call<GoProResponse> R5MPM = GoProApi.config(param,"3");

        }
        public static class Shutter{
            static String param="19";
            public static Call<GoProResponse> ShutterAuto = GoProApi.config(param,"0");
            public static Call<GoProResponse> Shutter2S = GoProApi.config(param,"1");
            public static Call<GoProResponse> Shutter5S = GoProApi.config(param,"2");
            public static Call<GoProResponse> Shutter10S = GoProApi.config(param,"3");
            public static Call<GoProResponse> Shutter15S = GoProApi.config(param,"4");
            public static Call<GoProResponse> Shutter20S = GoProApi.config(param,"5");
            public static Call<GoProResponse> Shutter30S = GoProApi.config(param,"6");

        }
        public static class SpotMeter{
            static String param="20";
            public static Call<GoProResponse> ON = GoProApi.config(param,"1");
            public static Call<GoProResponse> OFF = GoProApi.config(param,"0");

        }
        public static class WDR{
            static String param="77";
            public static Call<GoProResponse> ON = GoProApi.config(param,"1");
            public static Call<GoProResponse> OFF = GoProApi.config(param,"0");

        }
        public static class RAW{
            static String param="82";
            public static Call<GoProResponse> ON = GoProApi.config(param,"1");
            public static Call<GoProResponse> OFF = GoProApi.config(param,"0");

        }
        public static class Protune{
            static String param="21";
            public static Call<GoProResponse> ON = GoProApi.config(param,"1");
            public static Call<GoProResponse> OFF = GoProApi.config(param,"0");

        }
        public static class WhiteBalance{
            static String param="22";
            public static Call<GoProResponse> WBAuto = GoProApi.config(param,"0");
            public static Call<GoProResponse> WB3000K = GoProApi.config(param,"1");
            public static Call<GoProResponse> WB4000K = GoProApi.config(param,"5");
            public static Call<GoProResponse> WB4800K = GoProApi.config(param,"6");
            public static Call<GoProResponse> WB5500K = GoProApi.config(param,"2");
            public static Call<GoProResponse> WB6000K = GoProApi.config(param,"7");
            public static Call<GoProResponse> WB6500K = GoProApi.config(param,"3");
            public static Call<GoProResponse> WBNative = GoProApi.config(param,"4");

        }
        public static class Color{
            static String param="23";
            public static Call<GoProResponse> GoProColor = GoProApi.config(param,"0");
            public static Call<GoProResponse> Flat = GoProApi.config(param,"1");

        }
        public static class Sharpness{
            static String param="25";
            public static Call<GoProResponse> High = GoProApi.config(param,"0");
            public static Call<GoProResponse> Medium = GoProApi.config(param,"1");
            public static Call<GoProResponse> Low = GoProApi.config(param,"2");

        }
        public static class EVComp{
            static String param="26";
            public static Call<GoProResponse> EVMinus2_0 = GoProApi.config(param,"8");
            public static Call<GoProResponse> EVMinus1_5 = GoProApi.config(param,"7");
            public static Call<GoProResponse> EVMinus1_0 = GoProApi.config(param,"6");
            public static Call<GoProResponse> EVMinus0_5 = GoProApi.config(param,"5");
            public static Call<GoProResponse> EV0_0 = GoProApi.config(param,"4");
            public static Call<GoProResponse> EV0_5 = GoProApi.config(param,"3");
            public static Call<GoProResponse> EV1_0 = GoProApi.config(param,"2");
            public static Call<GoProResponse> EV1_5 = GoProApi.config(param,"1");
            public static Call<GoProResponse> EV2_0 = GoProApi.config(param,"0");

        }
        public static class ISOMin{
            static String param="75";
            public static Call<GoProResponse> ISO800 = GoProApi.config(param,"0");
            public static Call<GoProResponse> ISO400 = GoProApi.config(param,"1");
            public static Call<GoProResponse> ISO200 = GoProApi.config(param,"2");
            public static Call<GoProResponse> ISO100 = GoProApi.config(param,"3");

        }
        public static class ISOMax{
            static String param="24";
            public static Call<GoProResponse> ISO800 = GoProApi.config(param,"0");
            public static Call<GoProResponse> ISO400 = GoProApi.config(param,"1");
            public static Call<GoProResponse> ISO200 = GoProApi.config(param,"2");
            public static Call<GoProResponse> ISO100 = GoProApi.config(param,"3");
        }
    }
}
