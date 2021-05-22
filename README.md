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
    <version>2.0.0</version>
</dependency>
```

## Example 📄
```java
private AtomicClient atomicClient;

private void test() {
  this.atomicClient = new AtomicClient();
  
  Channel channel = this.atomicClient.getChannel(Channels.ONE);
  Channel.Song song = channel.getSong();
  
  System.out.println(MessageFormat.format("[{0}] {1} - {2}", channel.getName(), song.getArtist(), song.getTitle()));
}
```

## AtomicClient 📗
```java
/**
 * Returns the live status of the channel atr.one.
 * @return Returns the live status.
 */
.isLive();

/**
 * Returns the streamer name when someone is live at atr.one.
 * @return Returns the name of the streamer.
 */
.getStreamer();
 
/**
 * Returns all informations about a channel.
 * @param channel
 * @return Returns the channel object.
 */
.getChannel(Channels channel);

/**
 * Returns the listener count of all channels.
 * @return Returns the listener count as a Integer.
 */
.getAllListeners();
```
