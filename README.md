React Grails Asset-Pipeline Plugin
================================
A Plugin that adds JSX template precompilation and react assets to the Grails Asset-Pipeline Plugin.

For more information on how to use asset-pipeline, click [here](http://www.github.com/bertramdev/asset-pipeline).

Installation
-----
add
```
compile(':react-asset-pipeline:1.0.7')
```
to your BuildConfig.groovy

Usage
-----
If you just want react assets in your app you can either require react (for only react.js) or react-with-jsx (for browser side jsx compilation)

e.g.
```
//= require react-with-jsx
```

Template Precompilation
-----
The real power of this plugin is the server side precompilation of JSX templates.
Put your jsx templates in grails-app/assets/javascripts folder (or subfolders) and reference them with the provided <asset:reactTemplate src="filename.jsx"/> tag.
As you may already know from asset-pipeline plugin, you can build template packages by referencing files like in javascript

e.g. having a pager.jsx that looks like this
```
//= require pager/pager.jsx
//= require pager/pager-next-button.jsx
//= require pager/pager-page-button.jsx
//= require pager/pager-prev-button.jsx
```
which will result in a single compiled JSX Tempalte file with the referenced templates in it.

You can now get rid of browser side JSX and just use the "react" asset.


ToDo
-----
* add Config.groovy option to change template compilation options
