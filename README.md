## Action Cam Control App for Android

Open source vendor agnostic client application to interface with most popular sports cameras (eg: GoPro, Sony, Garmin, Yi, Eken, SJCam, etc...).

### Aims:

- Open source and login-free
- Virtually permissionless
- Support most action cameras
- Have all the features from the vendor's client
- Run without Google Play Services

### Mockup of the app UI:

*Disclaimer: Not a designer.*

![](https://i.imgur.com/6NyLUrL.png)

### Works with:

- GoPro - [API](http://github.com/konradit/goprowifihack)

### Planned:

- Sony ActionCam
- RunCam
- Garmin
- Xiaomi Yi
- Eken
- SJcam
- Other ChinaPro to be added

### Features:


The app must *at least* have the following features regardless of camera used:

- Preview live stream
- Control basic features eg: record, take picture, change modes, turn on or off
- Get camera status messages
- Get videos and photos off memory
- Camera detection

### Contribute!

I maintain the GoPro Wifi API and I will be doing the GoPro support, if you want to add support for your action camera:

- See the /camera/goproAPI folder, this is what provides the app with instructions and assets on how to connect to a GoPro camera, add a new folder inside /camera/ named ```camera name```API, inside you'll need to place the following files: 
	- Camera.java: Details about the camera(s) itself: ```model_name``` array, ```ip_address``` as a string, ```baseURL```, ```statusURL```, ```settingsURL```, ```commandURL``` as string (with :port if needed), ```connectionMsg``` array as string (this is to check if the camera is connected, first item should be a URL and second item should be a string), ```info``` array with information from the vendor (eg: vendor name, vendor country, vendor website)
	- Constants.java: Host your commands in this file, I tend to follow a Video/Photo/MultiShot/Setup/Command structure which is easy to understand and use. Other cameras are different but try to stick to that structure.
	- Live.java: This should have a function called ```getStream``` that returns a Uri or a Video that ExoPlayer can play.
	- Media.java: Many cameras have a media front end in their IP addresses with port 8080, you'll need the URL the vendor app uses, for GoPro for instance its a JSON. It should have a ```mediaURL``` Uri and a function called ```getMedia()``` which returns an array with the URLs of the photos and videos.
	- Status.java: Should be a list of Strings or integers with an appropiate Status name.
