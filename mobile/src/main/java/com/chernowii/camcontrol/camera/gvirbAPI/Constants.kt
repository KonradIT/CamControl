package com.chernowii.camcontrol.camera.gvirbAPI


import java.net.URI

/**
 * Created by konrad on 1/2/17.
 */

object Constants {
    fun baseUri(param: String, `val`: String): String {
        return "http://10.5.5.9/gp/gpControl/setting/$param/$`val`"
    }

    object Shutter {
        var shutter = URI.create("http://10.5.5.9/gp/gpControl/command/shutter?p=1")
        var stop = URI.create("http://10.5.5.9/gp/gpControl/command/shutter?p=0")
        var hilight = URI.create("http://10.5.5.9/gp/gpControl/command/storage/tag_moment")
    }

    object cameraModes {
        var videoMode = URI.create("http://10.5.5.9/gp/gpControl/command/mode?p=0")
        var photoMode = URI.create("http://10.5.5.9/gp/gpControl/command/mode?p=1")
        var multishotMode = URI.create("http://10.5.5.9/gp/gpControl/command/mode?p=2")
    }

    object videoSubModes {
        var Video = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=0&sub_mode=0")
        var TimeLapseVideo = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=0&sub_mode=1")
        var VideoPlusPhoto = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=0&sub_mode=2")
        var Looping = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=0&sub_mode=3")
    }

    object photoSubModes {
        var Single = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=1&sub_mode=0")
        var Continuous = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=1&sub_mode=1")
        var Night = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=1&sub_mode=2")
    }

    object multiShotSubModes {
        var Burst = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=2&sub_mode=0")
        var Timelapse = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=2&sub_mode=1")
        var NightLapse = URI.create("http://10.5.5.9/gp/gpControl/command/sub_mode?mode=2&sub_mode=2")
    }

    class Setup {
        object Orientation {
            var Up = URI.create(baseUri("52", "1"))
            var Down = URI.create(baseUri("52", "2"))
            var Auto = URI.create(baseUri("52", "0"))
        }

        object Locate {

            var On = URI.create("http://10.5.5.9/gp/gpControl/command/system/locate?p=1")
            var Off = URI.create("http://10.5.5.9/gp/gpControl/command/system/locate?p=0")

        }

        object Delete {
            var DeleteFile = URI.create("//10.5.5.9/gp/gpControl/command/storage/delete?p=file")
            var DeleteLast = URI.create("//10.5.5.9/gp/gpControl/command/storage/delete/last")
            var Format = URI.create("//10.5.5.9/gp/gpControl/command/storage/delete/all")
        }

        object QuickCapture {
            var On = URI.create(baseUri("54", "1"))
            var Off = URI.create(baseUri("54", "0"))

        }

        object LEDBlink {
            var Two = URI.create(baseUri("55", "1"))
            var Four = URI.create(baseUri("55", "2"))
            var Off = URI.create(baseUri("55", "0"))

        }

        object Beeps {
            var Off = URI.create(baseUri("56", "2"))
            var SeventyPercent = URI.create(baseUri("56", "1"))
            var Full = URI.create(baseUri("56", "0"))

        }

        object VideoFormat {
            var NTSC = URI.create(baseUri("57", "0"))
            var PAL = URI.create(baseUri("57", "1"))

        }

        object LCDDisplay {
            var On = URI.create(baseUri("72", "1"))
            var Off = URI.create(baseUri("72", "0"))

        }

        object OnScreenDisplay {
            var On = URI.create(baseUri("58", "1"))
            var Off = URI.create(baseUri("58", "0"))

        }

        object LCDBrightness {
            var High = URI.create(baseUri("49", "0"))
            var Medium = URI.create(baseUri("49", "1"))
            var Low = URI.create(baseUri("49", "2"))

        }

        object LCDLock {
            var On = URI.create(baseUri("50", "1"))
            var Off = URI.create(baseUri("50", "0"))

        }

        object LCDTimeout {

            var Never = URI.create(baseUri("51", "0"))
            var LCD1min = URI.create(baseUri("51", "1"))
            var LCD2min = URI.create(baseUri("51", "2"))
            var LCD3min = URI.create(baseUri("51", "3"))

        }

        object AutoOff {
            var Never = URI.create(baseUri("59", "0"))
            var AO1m = URI.create(baseUri("59", "1"))
            var AO2m = URI.create(baseUri("59", "2"))
            var AO3m = URI.create(baseUri("59", "3"))
            var AO5m = URI.create(baseUri("59", "4"))

        }
    }

    class Video {
        object Resolutions {
            var Res4K = URI.create(baseUri("2", "1"))
            var Res4K_SuperView = URI.create(baseUri("2", "2"))
            var Res2point7K = URI.create(baseUri("2", "4"))
            var Res2point7KSuperView = URI.create(baseUri("2", "5"))
            var Res2point7K_4by3AR = URI.create(baseUri("2", "6"))
            var Res1440p = URI.create(baseUri("2", "7"))
            var Res1080pSuperView = URI.create(baseUri("2", "8"))
            var Res1080p = URI.create(baseUri("2", "9"))
            var Res960p = URI.create(baseUri("2", "10"))
            var Res720pSuperView = URI.create(baseUri("2", "11"))
            var Res720p = URI.create(baseUri("2", "12"))
            var ResWVGA = URI.create(baseUri("2", "13"))
        }

        object FrameRate {
            var FR240fps = URI.create(baseUri("3", "0"))
            var FR120fps = URI.create(baseUri("3", "1"))
            var FR100fps = URI.create(baseUri("3", "2"))
            var FR60fps = URI.create(baseUri("3", "5"))
            var FR50fps = URI.create(baseUri("3", "6"))
            var FR48fps = URI.create(baseUri("3", "7"))
            var FR30fps = URI.create(baseUri("3", "8"))
            var FR25fps = URI.create(baseUri("3", "9"))
            var FR24fps = URI.create(baseUri("3", "10"))
            var FR15fps = URI.create(baseUri("3", "11"))
            var FR12point5fps = URI.create(baseUri("3", "12"))
        }

        object FOV {

            var Wide = URI.create(baseUri("4", "0"))
            var Medium = URI.create(baseUri("4", "1"))
            var Narrow = URI.create(baseUri("4", "2"))
            var Linear = URI.create(baseUri("4", "4"))
        }

        object LowLight {
            var On = URI.create(baseUri("8", "1"))
            var Off = URI.create(baseUri("8", "0"))
        }

        object LoopingDuration {

            var Max = URI.create(baseUri("6", "0"))
            var Loop5Min = URI.create(baseUri("6", "1"))
            var Loop20Min = URI.create(baseUri("6", "2"))
            var Loop60Min = URI.create(baseUri("6", "3"))
            var Loop120Min = URI.create(baseUri("6", "4"))
        }

        object VideoPlusPhotoInterval {

            var Interval5Min = URI.create(baseUri("7", "1"))
            var Interval10Min = URI.create(baseUri("7", "2"))
            var Interval30Min = URI.create(baseUri("7", "3"))
            var Interval60Min = URI.create(baseUri("7", "4"))
        }

        object SpotMeter {

            var Off = URI.create(baseUri("9", "0"))
            var On = URI.create(baseUri("9", "1"))
        }

        object ProTune {
            var On = URI.create(baseUri("10", "1"))
            var Off = URI.create(baseUri("10", "0"))
        }

        object WhiteBalance {

            var WBAuto = URI.create(baseUri("11", "0"))
            var WB3000k = URI.create(baseUri("11", "1"))
            var WB4000k = URI.create(baseUri("11", "5"))
            var WB4800k = URI.create(baseUri("11", "6"))
            var WB5500k = URI.create(baseUri("11", "2"))
            var WB6000k = URI.create(baseUri("11", "7"))
            var WB6500k = URI.create(baseUri("11", "3"))
            var WBNative = URI.create(baseUri("11", "4"))
        }

        object Color {

            var GOPRO = URI.create(baseUri("12", "0"))
            var Flat = URI.create(baseUri("12", "1"))
        }

        object ISOLimit {
            var ISO6400 = URI.create(baseUri("13", "0"))
            var ISO1600 = URI.create(baseUri("13", "1"))
            var ISO400 = URI.create(baseUri("13", "2"))
            var ISO3200 = URI.create(baseUri("13", "3"))
            var ISO800 = URI.create(baseUri("13", "4"))
            var ISO200 = URI.create(baseUri("13", "7"))
            var ISO100 = URI.create(baseUri("13", "8"))
        }

        object ISOMode {
            var Max = URI.create(baseUri("74", "0"))
            var Lock = URI.create(baseUri("74", "1"))
        }

        object Sharpness {
            var High = URI.create(baseUri("14", "0"))
            var Med = URI.create(baseUri("14", "1"))
            var Low = URI.create(baseUri("14", "2"))
        }

        object ManualVideoExposure {
            var MVE_AutoMode = URI.create(baseUri("73", "0"))

            object FR24FPS {
                var MVE_1_24 = URI.create(baseUri("73", "3"))
                var MVE_1_48 = URI.create(baseUri("73", "6"))
                var MVE_1_96 = URI.create(baseUri("73", "11"))
            }

            object FR30FPS {
                var MVE_1_30 = URI.create(baseUri("73", "5"))
                var MVE_1_60 = URI.create(baseUri("73", "8"))
                var MVE_1_120 = URI.create(baseUri("73", "13"))
            }

            object FR48FPS {
                var MVE_1_48 = URI.create(baseUri("73", "6"))
                var MVE_1_96 = URI.create(baseUri("73", "11"))
                var MVE_1_192 = URI.create(baseUri("73", "16"))
            }

            object FR60FPS {
                var MVE_1_60 = URI.create(baseUri("73", "8"))
                var MVE_1_120 = URI.create(baseUri("73", "13"))
                var MVE_1_240 = URI.create(baseUri("73", "18"))
            }

            object FR90FPS {
                var MVE_1_90 = URI.create(baseUri("73", "10"))
                var MVE_1_180 = URI.create(baseUri("73", "15"))
                var MVE_1_360 = URI.create(baseUri("73", "20"))
            }

            object FR120FPS {
                var MVE_1_120 = URI.create(baseUri("73", "13"))
                var MVE_1_240 = URI.create(baseUri("73", "18"))
                var MVE_1_480 = URI.create(baseUri("73", "22"))
            }

            object FR240FPS {
                var MVE_1_120 = URI.create(baseUri("73", "18"))
                var MVE_1_240 = URI.create(baseUri("73", "22"))
                var MVE_1_480 = URI.create(baseUri("73", "23"))

            }
        }
    }

    class Photo
}
