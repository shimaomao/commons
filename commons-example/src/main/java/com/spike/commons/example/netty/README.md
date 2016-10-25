# com.spike.netty descriptions

## com.spike.netty.userguide
 cited from [User guide for 4.x](http://netty.io/wiki/user-guide-for-4.x.html)

## others
The codes are cited from *Maurer N.. Nettiy in Action MEAP V5. Manning Publications. 2013*,

 so this document is structured as core chapters of the book.

# offical links
+ [Documentation](http://netty.io/wiki/)
+ [User guide for 4.x](http://netty.io/wiki/user-guide-for-4.x.html)
+ [4.0.28 Final javadoc](http://netty.io/4.0/api/index.html)
+ [Related articles](http://netty.io/wiki/related-articles.html)

# GETTING STARTED
## First Netty Application : *com.spike.netty.first*
1. important things when building a server(using NIO)

+ create a *ServerBootstrap* instance to bootstrap the server, and bind it later;
+ create and assign the *NioEventLoopGroup* instance to *ServerBootstrap*  to handle event processing,such as accepting new connections, receiving data, write data and so on;
+ specify the local *InetSocketAddress* to which the server binds;
+ set up a *childHandler* to executes for every accepted connection 
+ call *ServerBootStrap.bind()* to bind the server

2. important things when building a client(using NIO)

+ create *Bootstrap* instance to bootstrap the client
+ create and assign *NioEventLoopGroup* instance to *Bootstrap*  to handle event processing
+ specify the remote *InetSocketAddress* to which the client will connect
+ set up a *childHandler* to executes once the connection is established
+ call *Bootstrap.connect()* to connect to the remote peer

*childHandler* helper or adapter classes:
+ *ChannelInBoundHandlerAdapter*
	release resources after handled the received message
+ *SimpleChannelInboundHandlerAdapter<ByteBuf>*
	release the resource once *channelRead0()* method completes

## Netty Core Concepts
1. Bootstrap/ServerBootstrap
A *Bootstrap* is a construct Netty provides the make it easy to configure how Netty should setup the application.

2. handler
In order to support multiple protocols and various ways of processing data, Netty abstracted the *handler*s;

*handler*s are designed to handle one or sets of events in Netty, the events may be converting objects to bytes or visa-verse, or throw exceptions 
when processing the data.

*ChannelInboundHandler*  is a handler, it receive messages which user can process or write/flush to generate response, i.e. it's a place to put business logic of your application.

The message processing procedure may be complicated enough, which encourages users to use multiple handlers working together. Netty support *ChannelInitializer* to add 
*ChannelHandler* implementations to *ChannelPipeline*. A *ChannelInitializer* is itself a *ChannelHander*, which remove itself from the *ChannelPipeline* once it has added other handlers.

3. ChannelPipeline, EventLoop, EventLoopGroup
A *Channel* is a representation for a socket connection or some component capable of performing IO operations.

The purpose of *EventLoop* is to process IO operations of a *Channel*.

The *EventLoopGroup* may contains more than one *EventLoop*, and can be used to obtain an *EventLoop*.
 
All IO operation in Netty are performed **asynchronously**, Netty uses Future and *ChannelFuture*. *ChannelFuture*s can be used to register a listener, which will be notified when an operation has either failed or completed successfully.

### specific concepts in details
#### Channels, events and input/output
Netty is a non-blocking, event driven, networking framework, which means Netty uses threads to process IO events.

When a *Channel* is registered/create, Netty **bind** the channel to a single *EventLoop* for the lifetime of the channel. 

The *EventLoop* is always bound to a single *Thread*, that never changes during its life time, which means all IO for a given *Channel*  is performed by the same thread.


#### bootstrapping

#### channel handlers and data flow

#### specific handlers: encoder, decoder and domain logic


# CORE FUNCTIONS/PARTS
## Transport


## Buffers


## ChannelHandler


## Codec


## Bootstrapping Netty Applications


# NETTY BY EXAMPLE
## unit test

## WebSocket

## broadcast


# ADVANCE TOPIC
## custom codec

## thread model

## EventLoop
