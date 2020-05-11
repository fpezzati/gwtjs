# gwtjs
I'm trying to wrap some GWT code in a web component (no html import, no polymer). 
I'm finding some difficulties, here they follow.

Well I read some blog posts about JSInterop and how it works. Looks great, I stumble into GWT in 2012, have a break and back again in 2018. Let's try to use JSInterop to share my GWT widgets in a web component (at which I am a newbie).

This is my move: write a GWT widget, export it by JSInterop and use it by a webcomponent. Export the code and use an event to interact with my widget by another component, maybe the parent one. But I get some problems..

## my widgets can't be used in javascript
While the gwt code is ready, using a method of my widget (something implementing `com.google.gwt.user.client.ui.IsWidget`)) gives me a weird error I can't get:

`EffortTable.java:16 Uncaught TypeError: this.$init_933_g$ is not a function
    at Object.iMd_g$ [as EffortTable] (EffortTable.java:16)
iMd_g$ @ EffortTable.java:16`

## can't get when gwt code will be ready to be used in javascript
Maybe this is not a real issue. Maybe I only have to go another way, let my entry point object deal with custom events..

So, how to procede? Try to use an event bus and JSInterop to share it with my GWT code? Try another type to inherit about my widget.. Some typo that is usable from javascript?

Let's try to keep things simple. First, stackoverflowing around I found an [answer](https://stackoverflow.com/questions/54611866/gwt-jsinterop-java-exporting-is-not-working) where Thomas Boyer states: 

> The real fix would be to either use a custom linker, or setup a callback that you'll call from GWT's onModuleLoad.

Ok, that could be a way to explore. But what about my widget that I can't use?

Well it turns out that problem was I miss a `new` keyword when instantiating my widget. So my code is visible and usable.

Now problem is, how to pass a json object containing some `java.util.List`? Well, simply JSInterop does not mess with collections. I have to rewrite something.