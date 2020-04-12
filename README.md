# gwtjs
I'm trying to wrap some GWT code in a web component (no html import, no polymer). 
I'm finding some difficulties, here they follow.

## my widgets can't be used in javascript
While the gwt code is ready, using a method of my widget (something implementing `com.google.gwt.user.client.ui.IsWidget`)) gives me a weird error I can't get:

`EffortTable.java:16 Uncaught TypeError: this.$init_933_g$ is not a function
    at Object.iMd_g$ [as EffortTable] (EffortTable.java:16)
iMd_g$ @ EffortTable.java:16`

## can't get when gwt code will be ready to be used in javascript
Maybe this is not a real issue. Maybe I only have to go another way, let my entry point object deal with custom events..