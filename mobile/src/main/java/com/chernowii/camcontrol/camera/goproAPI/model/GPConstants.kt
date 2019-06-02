package com.chernowii.camcontrol.camera.goproAPI.model


import com.chernowii.camcontrol.camera.goproAPI.ApiBase
import com.chernowii.camcontrol.camera.goproAPI.ApiClient

import java.net.URI

import retrofit2.Call

/**
 * Created by konrad on 1/2/17.
 */

object GPConstants {
    internal var GoProApi = ApiBase.mainClient.create(ApiClient::class.java!!)

    class Commands {
        object Stream {
            var Restart = GoProApi.execute("?p1=gpStream&a1=proto_v2&c1=restart")
        }

        object Shutter {
            var shutter = GoProApi.command("shutter", "1")
            var stop = GoProApi.command("shutter", "0")
            var hilight = GoProApi.command("storage/tag_moment", "")
        }

        object Modes {
            var videoMode = GoProApi.command("mode", "0")
            var photoMode = GoProApi.command("mode", "1")
            var multishotMode = GoProApi.command("mode", "2")

            object videoSubModes {
                var Video = GoProApi.command("sub_mode", "mode=0&sub_mode=0")
                var TimeLapseVideo = GoProApi.command("sub_mode", "mode=0&sub_mode=1")
                var VideoPlusPhoto = GoProApi.command("sub_mode", "mode=0&sub_mode=2")
                var Looping = GoProApi.command("sub_mode", "mode=0&sub_mode=3")
            }

            object photoSubModes {
                var Single = GoProApi.command("sub_mode", "mode=1&sub_mode=0")
                var Continuous = GoProApi.command("sub_mode", "mode=1&sub_mode=1")
                var Night = GoProApi.command("sub_mode", "mode=1&sub_mode=2")
            }

            object multiShotSubModes {
                var Burst = GoProApi.command("sub_mode", "mode=2&sub_mode=0")
                var Timelapse = GoProApi.command("sub_mode", "mode=2&sub_mode=1")
                var NightLapse = GoProApi.command("sub_mode", "mode=2&sub_mode=2")
            }
        }


    }

    class Setup {
        object Orientation {
            var Up = GoProApi.config("52", "1")
            var Down = GoProApi.config("52", "2")
            var Auto = GoProApi.config("52", "0")
        }

        object Locate {

            var On = GoProApi.command("system/locate", "1")
            var Off = GoProApi.command("system/locate", "0")

        }

        object Delete {
            var DeleteFile = GoProApi.command("storage/delete", "file")
            var DeleteLast = GoProApi.command("storage/delete/last", "")
            var Format = GoProApi.command("storage/delete/all", "")
        }

        object QuickCapture {
            var On = GoProApi.config("54", "1")
            var Off = GoProApi.config("54", "0")

        }

        object LEDBlink {
            var Two = GoProApi.config("55", "1")
            var Four = GoProApi.config("55", "2")
            var Off = GoProApi.config("55", "0")

        }

        object Beeps {
            var Off = GoProApi.config("56", "2")
            var SeventyPercent = GoProApi.config("56", "1")
            var Full = GoProApi.config("56", "0")

        }

        object VideoFormat {
            var NTSC = GoProApi.config("57", "0")
            var PAL = GoProApi.config("57", "1")

        }

        object LCDDisplay {
            var On = GoProApi.config("72", "1")
            var Off = GoProApi.config("72", "0")

        }

        object OnScreenDisplay {
            var On = GoProApi.config("58", "1")
            var Off = GoProApi.config("58", "0")

        }

        object LCDBrightness {
            var High = GoProApi.config("49", "0")
            var Medium = GoProApi.config("49", "1")
            var Low = GoProApi.config("49", "2")

        }

        object LCDLock {
            var On = GoProApi.config("50", "1")
            var Off = GoProApi.config("50", "0")

        }

        object LCDTimeout {

            var Never = GoProApi.config("51", "0")
            var LCD1min = GoProApi.config("51", "1")
            var LCD2min = GoProApi.config("51", "2")
            var LCD3min = GoProApi.config("51", "3")

        }

        object AutoOff {
            var Never = GoProApi.config("59", "0")
            var AO1m = GoProApi.config("59", "1")
            var AO2m = GoProApi.config("59", "2")
            var AO3m = GoProApi.config("59", "3")
            var AO5m = GoProApi.config("59", "4")

        }
    }

    class Video {
        object Resolutions {
            var Res4K = GoProApi.config("2", "1")
            var Res4K_SuperView = GoProApi.config("2", "2")
            var Res2point7K = GoProApi.config("2", "4")
            var Res2point7KSuperView = GoProApi.config("2", "5")
            var Res2point7K_4by3AR = GoProApi.config("2", "6")
            var Res1440p = GoProApi.config("2", "7")
            var Res1080pSuperView = GoProApi.config("2", "8")
            var Res1080p = GoProApi.config("2", "9")
            var Res960p = GoProApi.config("2", "10")
            var Res720pSuperView = GoProApi.config("2", "11")
            var Res720p = GoProApi.config("2", "12")
            var ResWVGA = GoProApi.config("2", "13")
        }

        object FrameRate {
            var FR240fps = GoProApi.config("3", "0")
            var FR120fps = GoProApi.config("3", "1")
            var FR100fps = GoProApi.config("3", "2")
            var FR60fps = GoProApi.config("3", "5")
            var FR50fps = GoProApi.config("3", "6")
            var FR48fps = GoProApi.config("3", "7")
            var FR30fps = GoProApi.config("3", "8")
            var FR25fps = GoProApi.config("3", "9")
            var FR24fps = GoProApi.config("3", "10")
            var FR15fps = GoProApi.config("3", "11")
            var FR12point5fps = GoProApi.config("3", "12")
        }

        object FOV {

            var Wide = GoProApi.config("4", "0")
            var Medium = GoProApi.config("4", "1")
            var Narrow = GoProApi.config("4", "2")
            var Linear = GoProApi.config("4", "4")
        }

        object LowLight {
            var On = GoProApi.config("8", "1")
            var Off = GoProApi.config("8", "0")
        }

        object LoopingDuration {

            var Max = GoProApi.config("6", "0")
            var Loop5Min = GoProApi.config("6", "1")
            var Loop20Min = GoProApi.config("6", "2")
            var Loop60Min = GoProApi.config("6", "3")
            var Loop120Min = GoProApi.config("6", "4")
        }

        object VideoPlusPhotoInterval {

            var Interval5Min = GoProApi.config("7", "1")
            var Interval10Min = GoProApi.config("7", "2")
            var Interval30Min = GoProApi.config("7", "3")
            var Interval60Min = GoProApi.config("7", "4")
        }

        object SpotMeter {

            var Off = GoProApi.config("9", "0")
            var On = GoProApi.config("9", "1")
        }

        object ProTune {
            var On = GoProApi.config("10", "1")
            var Off = GoProApi.config("10", "0")
        }

        object WhiteBalance {

            var WBAuto = GoProApi.config("11", "0")
            var WB3000k = GoProApi.config("11", "1")
            var WB4000k = GoProApi.config("11", "5")
            var WB4800k = GoProApi.config("11", "6")
            var WB5500k = GoProApi.config("11", "2")
            var WB6000k = GoProApi.config("11", "7")
            var WB6500k = GoProApi.config("11", "3")
            var WBNative = GoProApi.config("11", "4")
        }

        object Color {

            var GOPRO = GoProApi.config("12", "0")
            var Flat = GoProApi.config("12", "1")
        }

        object ISOLimit {
            var ISO6400 = GoProApi.config("13", "0")
            var ISO1600 = GoProApi.config("13", "1")
            var ISO400 = GoProApi.config("13", "2")
            var ISO3200 = GoProApi.config("13", "3")
            var ISO800 = GoProApi.config("13", "4")
            var ISO200 = GoProApi.config("13", "7")
            var ISO100 = GoProApi.config("13", "8")
        }

        object ISOMode {
            var Max = GoProApi.config("74", "0")
            var Lock = GoProApi.config("74", "1")
        }

        object Sharpness {
            var High = GoProApi.config("14", "0")
            var Med = GoProApi.config("14", "1")
            var Low = GoProApi.config("14", "2")
        }

        object ManualVideoExposure {
            var MVE_AutoMode = GoProApi.config("73", "0")

            object FR24FPS {
                var MVE_1_24 = GoProApi.config("73", "3")
                var MVE_1_48 = GoProApi.config("73", "6")
                var MVE_1_96 = GoProApi.config("73", "11")
            }

            object FR30FPS {
                var MVE_1_30 = GoProApi.config("73", "5")
                var MVE_1_60 = GoProApi.config("73", "8")
                var MVE_1_120 = GoProApi.config("73", "13")
            }

            object FR48FPS {
                var MVE_1_48 = GoProApi.config("73", "6")
                var MVE_1_96 = GoProApi.config("73", "11")
                var MVE_1_192 = GoProApi.config("73", "16")
            }

            object FR60FPS {
                var MVE_1_60 = GoProApi.config("73", "8")
                var MVE_1_120 = GoProApi.config("73", "13")
                var MVE_1_240 = GoProApi.config("73", "18")
            }

            object FR90FPS {
                var MVE_1_90 = GoProApi.config("73", "10")
                var MVE_1_180 = GoProApi.config("73", "15")
                var MVE_1_360 = GoProApi.config("73", "20")
            }

            object FR120FPS {
                var MVE_1_120 = GoProApi.config("73", "13")
                var MVE_1_240 = GoProApi.config("73", "18")
                var MVE_1_480 = GoProApi.config("73", "22")
            }

            object FR240FPS {
                var MVE_1_120 = GoProApi.config("73", "18")
                var MVE_1_240 = GoProApi.config("73", "22")
                var MVE_1_480 = GoProApi.config("73", "23")

            }
        }

        object EVComp {
            internal var param = "15"
            var EVMinus2_0 = GoProApi.config(param, "8")
            var EVMinus1_5 = GoProApi.config(param, "7")
            var EVMinus1_0 = GoProApi.config(param, "6")
            var EVMinus0_5 = GoProApi.config(param, "5")
            var EV0_0 = GoProApi.config(param, "4")
            var EV0_5 = GoProApi.config(param, "3")
            var EV1_0 = GoProApi.config(param, "2")
            var EV1_5 = GoProApi.config(param, "1")
            var EV2_0 = GoProApi.config(param, "0")

        }
    }

    class Photo {

        object ContinuousRate {
            internal var param = "18"
            var C3PPS = GoProApi.config(param, "0")
            var C5PPS = GoProApi.config(param, "1")
            var C10PPS = GoProApi.config(param, "2")

        }

        object Resolution {
            internal var param = "17"
            var R12MPW = GoProApi.config(param, "0")
            var R12MPL = GoProApi.config(param, "10")
            var R12MPM = GoProApi.config(param, "8")
            var R12MPN = GoProApi.config(param, "9")
            var R10MPW = GoProApi.config(param, "4")
            var R10MPL = GoProApi.config(param, "11")
            var R8MPW = GoProApi.config(param, "0")
            var R7MPW = GoProApi.config(param, "1")
            var R7MPM = GoProApi.config(param, "2")
            var R5MPM = GoProApi.config(param, "3")

        }

        object Shutter {
            internal var param = "19"
            var ShutterAuto = GoProApi.config(param, "0")
            var Shutter2S = GoProApi.config(param, "1")
            var Shutter5S = GoProApi.config(param, "2")
            var Shutter10S = GoProApi.config(param, "3")
            var Shutter15S = GoProApi.config(param, "4")
            var Shutter20S = GoProApi.config(param, "5")
            var Shutter30S = GoProApi.config(param, "6")

        }

        object SpotMeter {
            internal var param = "20"
            var ON = GoProApi.config(param, "1")
            var OFF = GoProApi.config(param, "0")

        }

        object WDR {
            internal var param = "77"
            var ON = GoProApi.config(param, "1")
            var OFF = GoProApi.config(param, "0")

        }

        object RAW {
            internal var param = "82"
            var ON = GoProApi.config(param, "1")
            var OFF = GoProApi.config(param, "0")

        }

        object Protune {
            internal var param = "21"
            var ON = GoProApi.config(param, "1")
            var OFF = GoProApi.config(param, "0")

        }

        object WhiteBalance {
            internal var param = "22"
            var WBAuto = GoProApi.config(param, "0")
            var WB3000K = GoProApi.config(param, "1")
            var WB4000K = GoProApi.config(param, "5")
            var WB4800K = GoProApi.config(param, "6")
            var WB5500K = GoProApi.config(param, "2")
            var WB6000K = GoProApi.config(param, "7")
            var WB6500K = GoProApi.config(param, "3")
            var WBNative = GoProApi.config(param, "4")

        }

        object Color {
            internal var param = "23"
            var GoProColor = GoProApi.config(param, "0")
            var Flat = GoProApi.config(param, "1")

        }

        object Sharpness {
            internal var param = "25"
            var High = GoProApi.config(param, "0")
            var Medium = GoProApi.config(param, "1")
            var Low = GoProApi.config(param, "2")

        }

        object EVComp {
            internal var param = "26"
            var EVMinus2_0 = GoProApi.config(param, "8")
            var EVMinus1_5 = GoProApi.config(param, "7")
            var EVMinus1_0 = GoProApi.config(param, "6")
            var EVMinus0_5 = GoProApi.config(param, "5")
            var EV0_0 = GoProApi.config(param, "4")
            var EV0_5 = GoProApi.config(param, "3")
            var EV1_0 = GoProApi.config(param, "2")
            var EV1_5 = GoProApi.config(param, "1")
            var EV2_0 = GoProApi.config(param, "0")

        }

        object ISOMin {
            internal var param = "75"
            var ISO800 = GoProApi.config(param, "0")
            var ISO400 = GoProApi.config(param, "1")
            var ISO200 = GoProApi.config(param, "2")
            var ISO100 = GoProApi.config(param, "3")

        }

        object ISOMax {
            internal var param = "24"
            var ISO800 = GoProApi.config(param, "0")
            var ISO400 = GoProApi.config(param, "1")
            var ISO200 = GoProApi.config(param, "2")
            var ISO100 = GoProApi.config(param, "3")
        }
    }
}
