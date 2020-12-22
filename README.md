<p align="center">
  <a href="https://atomicradio.eu">
    <img alt="atomicradio" src="https://cdn.atomicnetworks.eu/logo/coloured.png" width="150" />
  </a>
</p>
<h1 align="center">
  AtomicRadio Library 📚
</h1>
<p align="center">
   The java library for the <a href="https://api.atomicradio.eu">atomicradio web-api</a>.
</p>
<p align="center">
  <a href="https://gitmoji.carloscuesta.me">
      <img src="https://img.shields.io/badge/gitmoji-%20😜%20😍-FFDD67.svg?style=flat-square" alt="Gitmoji">
  </a>  
</p>

## Maven 🔧
```xml
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>

<dependency>
    <groupId>com.github.atomicnetworkseu</groupId>
    <artifactId>atomicradio-library</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Example 📄
```java
private AtomicClient atomicClient;

private void test() {
  this.atomicClient = new AtomicClient();
  
  String artist = this.atomicClient.getChannelOne().getSong().getArtist();
  String title = this.atomicClient.getChannelOne().getSong().getTitle();
  System.out.println(artist + " - " + title);
}
```

## AtomicClient 📗
```java
/**
 * Returns the live status of the channel atr.one.
 */
.isLive();

/**
 * Returns the streamer name when someone is live at atr.one.
 */
.getStreamer();
 
/**
 * Returns all channel informations of atr.one.
 */
.getChannelOne()

/**
 * Returns all channel informations of atr.dance.
 */
.getChannelDance()

/**
 * Returns all channel informations of atr.trap.
 */
.getChannelTrap()
```
