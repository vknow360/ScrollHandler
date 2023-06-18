# ScrollHandler
Extension to handle the scroll and properties of Scroll Views (For MIT AI2 and its distros)

**Latest Version:** 1.4 <br>
**Last Updated:** June 18, 2023 <br>

### Blocks 
![image](https://user-images.githubusercontent.com/41724811/124578818-2dbb0e80-de6c-11eb-82ef-ab5c94076524.png) <br>
![image](https://user-images.githubusercontent.com/41724811/124578868-3b709400-de6c-11eb-94f4-a9c3c581d8bf.png) <br>
![image](https://user-images.githubusercontent.com/41724811/124578925-49beb000-de6c-11eb-9609-8d47159f6a79.png) <br>
![image](https://user-images.githubusercontent.com/41724811/124578987-5a6f2600-de6c-11eb-941c-27a28ca42eb7.png) <br>
![image](https://user-images.githubusercontent.com/41724811/124579178-82f72000-de6c-11eb-8d5b-936895cdad50.png) <br>

### Documentation

> <h3>OnHScroll</h3>Event raised when a scroll happens in hsa.
Params           |  []()       
---------------- | ------- 

```` scrollX | number````

 <br> 

> <h3>OnHTouchDown</h3>Event indicating a touch down on hsa.
 <br> 

> <h3>OnHTouchUp</h3>Event indicating a touch up on hsa.
 <br> 

> <h3>OnVScroll</h3>Event raised when a scroll happens in vsa.
Params           |  []()       
---------------- | ------- 

```` scrollY | number````

 <br> 

> <h3>OnVTouchDown</h3>Event indicating a touch down on vsa.
 <br> 

> <h3>OnVTouchUp</h3>Event indicating a touch up on vsa.
 <br> 

> <h3>CanHSAScrollHorizontally</h3>Returns whether HSA can scroll in left(-1) and right(1)
Params           |  []()       
---------------- | ------- 

```` direction | number````<br>

<br> <i>Return type : boolean</i>

 <br> 

> <h3>CanVSAScrollVertically</h3>Returns whether VSA can scroll in up(-1) and down(1)
Params           |  []()       
---------------- | ------- 

```` direction | number````<br>

<br> <i>Return type : boolean</i>

 <br> 

> <h3>HArrowScroll</h3>Handle scrolling in response to an left or right arrow click.
Params           |  []()       
---------------- | ------- 

```` direction | number````<br>

 <br> 

> <h3>HFling</h3>Fling the hsa with given velocity.Positive numbers mean that the finger/cursor is moving right the screen, which means we want to scroll towards the left.
Params           |  []()       
---------------- | ------- 

```` velocityX | number````<br>

 <br> 

> <h3>HFullScroll</h3>Handles scrolling in response to a 'home/end' shortcut press. This method will scroll the view to the left or right and give the focus to the leftmost/rightmost component in the new visible area. If no component is a good candidate for focus, this scrollview reclaims the focus.
Params           |  []()       
---------------- | ------- 

```` direction | number````<br>

 <br> 

> <h3>HGetScrollX</h3>Returns current scrollX position of hsa.0 if no view is registered.
<br> <i>Return type : number</i>

 <br> 

> <h3>HMaxScroll</h3>Returns max scroll position of hsa.0 if no view is registered.
<br> <i>Return type : number</i>

 <br> 

> <h3>HPageScroll</h3>Handles scrolling in response to a 'page up/down' shortcut press. This method will scroll the view by one page up or down and give the focus to the topleft/right component in the new visible area. If no component is a good candidate for focus, this scrollview reclaims the focus.
Params           |  []()       
---------------- | ------- 

```` direction | number````<br>

 <br> 

> <h3>RegisterHSA</h3>Registers given horizonatal scroll arrangement for method execution
Params           |  []()       
---------------- | ------- 

```` hsa | component````<br>

 <br> 

> <h3>RegisterVSA</h3>Registers given vertical scroll arrangement for method execution
Params           |  []()       
---------------- | ------- 

```` vsa | component````<br>

 <br> 

> <h3>ScrollBy</h3>Scrolls to given position by pixels.pX and pY are pixel value of scroll position.If hScrollView value is true then method will be executed for hsa.
Params           |  []()       
---------------- | ------- 

```` pX | number````<br>
```` pY | number````<br>
```` hScrollView | boolean````<br>

 <br> 

> <h3>ScrollTo</h3>Set the scrolled position of your view.sX and yX are the scroll position of view.If hScrollView value is true then method will be executed for hsa.
Params           |  []()       
---------------- | ------- 

```` sX | number````<br>
```` sY | number````<br>
```` hScrollView | boolean````<br>

 <br> 

> <h3>SmoothScrollBy</h3>Smoothly scrolls by the given pixel position of view.If any speed is set then it will use that speed for scrolling.
Params           |  []()       
---------------- | ------- 

```` pX | number````<br>
```` pY | number````<br>
```` hScrollView | boolean````<br>

 <br> 

> <h3>SmoothScrollTo</h3>Smoothly scrolls to given position.If any speed is set then it will use that speed for scrolling.
Params           |  []()       
---------------- | ------- 

```` sX | number````<br>
```` sY | number````<br>
```` hScrollView | boolean````<br>

 <br> 

> <h3>ToggleScrolling</h3>Toggles scrolling of specific scroll view
Params           |  []()       
---------------- | ------- 

```` enable | boolean````<br>
```` hscrollView | boolean````<br>

 <br> 

> <h3>UnregisterHSA</h3>Unregisters previously registered hsa.
 <br> 

> <h3>UnregisterVSA</h3>Unregisters previously registered vsa.
 <br> 

> <h3>VArrowScroll</h3>Handle scrolling in response to an up or down arrow click.
Params           |  []()       
---------------- | ------- 

```` direction | number````<br>

 <br> 

> <h3>VFling</h3>Fling the vsa with given velocity.Positive numbers mean that the finger/cursor is moving down the screen, which means we want to scroll towards the top.
Params           |  []()       
---------------- | ------- 

```` velocityY | number````<br>

 <br> 

> <h3>VFullScroll</h3>Handles scrolling in response to a 'home/end' shortcut press. This method will scroll the view to the top or bottom and give the focus to the topmost/bottommost component in the new visible area. If no component is a good candidate for focus, this scrollview reclaims the focus.
Params           |  []()       
---------------- | ------- 

```` direction | number````<br>

 <br> 

> <h3>VGetScrollY</h3>Returns current scrollY position of vsa.0 if no view is registered.
<br> <i>Return type : number</i>

 <br> 

> <h3>VMaxScroll</h3>Returns max scroll position of vsa.0 if no view is registered.
<br> <i>Return type : number</i>

 <br> 

> <h3>VPageScroll</h3>Handles scrolling in response to a 'page up/down' shortcut press. This method will scroll the view by one page up or down and give the focus to the topmost/bottommost component in the new visible area. If no component is a good candidate for focus, this scrollview reclaims the focus.
Params           |  []()       
---------------- | ------- 

```` direction | number````<br>

 <br> 

### External Links
https://community.kodular.io/t/scrollhandler-handle-the-scroll-of-scroll-views/78008 <br>
http://sunnythedeveloper.epizy.com/2020/08/14/scrollhandler-handle-the-scroll-of-scroll-views <br>
