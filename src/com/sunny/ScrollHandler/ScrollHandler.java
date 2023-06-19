package com.sunny.ScrollHandler;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.HorizontalScrollArrangement;
import com.google.appinventor.components.runtime.VerticalScrollArrangement;

public class ScrollHandler extends AndroidNonvisibleComponent{
  private final float deviceDensity;
  private HorizontalScrollView hscrollView;
  private ScrollView scrollView;
  private int hScrollSpeed = 0;
  private int scrollSpeed = 0;
  public ScrollHandler(ComponentContainer container){
    super(container.$form());
    Activity activity = container.$context();
    deviceDensity = container.$form().deviceDensity();
  }
  private int d2p(int d){
    return Math.round(d/deviceDensity);
  }
  private int p2d(int p){
    return Math.round(p*deviceDensity);
  }
  @SimpleFunction(description="Registers given horizonatal scroll arrangement for method execution")
  public void RegisterHSA(HorizontalScrollArrangement hsa){
    if (hscrollView == null) {
      hscrollView = (HorizontalScrollView)hsa.getView();
      hscrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
        @Override
        public void onScrollChanged() {
          if (hscrollView != null) {
            OnHScroll(d2p(hscrollView.getScrollX()));
          }
        }
      });
    }
  }
  /*@SimpleFunction
  public int Density(){
      return deviceDensity;
  }*/
  @SimpleFunction(description="Registers given vertical scroll arrangement for method execution")
  public void RegisterVSA(VerticalScrollArrangement vsa){
    if (scrollView == null) {
      scrollView = (ScrollView)vsa.getView();
      scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
        @Override
        public void onScrollChanged() {
          if (scrollView != null) {
            OnVScroll(d2p(scrollView.getScrollY()));
          }
        }
      });
    }
  }
  @SimpleFunction(description="Toggles scrolling of specific scroll view")
  public void ToggleScrolling(final boolean enable,boolean hscrollView){
    if (hscrollView) {
      if (this.hscrollView != null) {
        this.hscrollView.setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN){
              OnHTouchDown();
            }else if(motionEvent.getActionMasked() == MotionEvent.ACTION_UP){
              OnHTouchUp();
            }
            return !enable;
          }
        });
      }
    }else{
      if (scrollView != null) {
        scrollView.setOnTouchListener(new View.OnTouchListener() {
          @Override
          public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == MotionEvent.ACTION_DOWN){
              OnVTouchDown();
            }else if(motionEvent.getActionMasked() == MotionEvent.ACTION_UP){
              OnVTouchUp();
            }
            return !enable;
          }
        });
      }
    }
  }
  @SimpleFunction(description="Set the scrolled position of your view.sX and yX are the scroll position of view.If hScrollView value is true then method will be executed for hsa.")
  public void ScrollTo(final int sX,final int sY,boolean hScrollView){
    if (hScrollView && hscrollView != null){
      hscrollView.postDelayed(new Runnable() {
        @Override
        public void run() {
          hscrollView.scrollTo(p2d(sX),p2d(sY));
        }
      }, 300);
    }else if(!hScrollView && scrollView != null){
      scrollView.postDelayed(new Runnable() {
        @Override
        public void run() {
          scrollView.scrollTo(p2d(sX),p2d(sY));
        }
      }, 300);
    }
  }
  @SimpleFunction(description="Smoothly scrolls to given position.If any speed is set then it will use that speed for scrolling.")
  public void SmoothScrollTo(final int sX,final int sY,boolean hScrollView){
    if (hScrollView && hscrollView != null){
      if (hScrollSpeed != 0) {
        ObjectAnimator.ofInt(hscrollView,"scrollX",p2d(sX)).setDuration(hScrollSpeed).start();
        return;
      }
      hscrollView.postDelayed(new Runnable() {
        @Override
        public void run() {
          hscrollView.smoothScrollTo(p2d(sX),p2d(sY));
        }
      }, 300);
    }else if(!hScrollView && scrollView != null){
      if (scrollSpeed != 0) {
        ObjectAnimator.ofInt(scrollView,"scrollY",p2d(sY)).setDuration(scrollSpeed).start();
        return;
      }
      scrollView.postDelayed(new Runnable() {
        @Override
        public void run() {
          scrollView.smoothScrollTo(p2d(sX),p2d(sY));
        }
      }, 300);
    }
  }
  @SimpleFunction(description="Scrolls to given position by pixels.pX and pY are pixel value of scroll position.If hScrollView value is true then method will be executed for hsa.")
  public void ScrollBy(final int pX,final int pY,boolean hScrollView){
    if (hScrollView && hscrollView != null){
      hscrollView.postDelayed(new Runnable() {
        @Override
        public void run() {
          hscrollView.scrollBy(p2d(pX),p2d(pY));
        }
      }, 300);
    }else if(!hScrollView && scrollView != null){
      scrollView.postDelayed(new Runnable() {
        @Override
        public void run() {
          scrollView.scrollBy(p2d(pX),p2d(pY));
        }
      }, 300);
    }
  }
  @SimpleFunction(description="Smoothly scrolls by the given pixel position of view.If any speed is set then it will use that speed for scrolling.")
  public void SmoothScrollBy(final int pX,final int pY,boolean hScrollView){
    if (hScrollView && hscrollView != null) {
      if (hScrollSpeed != 0) {
        ObjectAnimator.ofInt(hscrollView,"scrollX",p2d(pX)).setDuration(hScrollSpeed).start();
        return;
      }
      hscrollView.postDelayed(new Runnable() {
        @Override
        public void run() {
          hscrollView.smoothScrollBy(p2d(pX),p2d(pY));
        }
      }, 300);
    }else if(!hScrollView && scrollView != null){
      if (scrollSpeed != 0) {
        ObjectAnimator.ofInt(scrollView,"scrollY",p2d(pY)).setDuration(scrollSpeed).start();
        return;
      }
      scrollView.postDelayed(new Runnable() {
        @Override
        public void run() {
          scrollView.smoothScrollBy(p2d(pX),p2d(pY));
        }
      }, 300);
    }
  }
  @SimpleFunction(description="Handle scrolling in response to an up or down arrow click.")
  public void VArrowScroll(int direction){
    if (scrollView != null) {
      scrollView.arrowScroll(direction);
    }
  }
  @SimpleFunction(description="Handle scrolling in response to an left or right arrow click.")
  public void HArrowScroll(int direction){
    if (hscrollView != null) {
      hscrollView.arrowScroll(direction);
    }

  }
  @SimpleFunction(description="Returns current scrollY position of vsa.0 if no view is registered.")
  public int VGetScrollY(){
    if (scrollView != null) {
      return d2p(scrollView.getScrollY());
    }
    return 0;
  }
  @SimpleFunction(description="Returns max scroll position of hsa.0 if no view is registered.")
  public int HMaxScroll(){
    if (hscrollView != null) {
      View view = hscrollView.getChildAt(hscrollView.getChildCount() - 1);
      return d2p(view.getRight() - hscrollView.getWidth());
    }
    return 0;
  }
  @SimpleFunction(description="Returns max scroll position of vsa.0 if no view is registered.")
  public int VMaxScroll(){
    if (scrollView != null) {
      View view = scrollView.getChildAt(scrollView.getChildCount() - 1);
      return d2p(view.getBottom() - scrollView.getHeight());
    }
    return 0;
  }
  @SimpleFunction(description="Returns current scrollX position of hsa.0 if no view is registered.")
  public int HGetScrollX(){
    if (hscrollView != null) {
      return d2p(hscrollView.getScrollX());
    }
    return 0;
  }
  /*@SimpleFunction
  public int VGetBottom(){
      if (scrollView != null) {
          return d2p(scrollView.getBottom());
      }
      return 0;
  }
  @SimpleFunction
  public int HGetRight(){
      if (hscrollView != null) {
          return d2p(hscrollView.getRight());
      }
      return 0;
  }*/
  @SimpleFunction(description = "Returns whether VSA can scroll in up(-1) and down(1)")
  public boolean CanVSAScrollVertically(int direction){
    if (scrollView != null) {
      return scrollView.canScrollVertically(direction);
    }
    return false;
  }
  @SimpleFunction(description = "Returns whether HSA can scroll in left(-1) and right(1)")
  public boolean CanHSAScrollHorizontally(int direction){
    if (hscrollView != null) {
      return hscrollView.canScrollHorizontally(direction);
    }
    return false;
  }
  /*@SimpleFunction
  public int HGetLeft(){
      if (hscrollView != null) {
          return d2p(hscrollView.getLeft());
      }
      return 0;
  }
  @SimpleFunction
  public int VGetTop(){
      if (scrollView != null) {
          return d2p(scrollView.getTop());
      }
      return 0;
  }*/
  @SimpleFunction(description="Handles scrolling in response to a 'page up/down' shortcut press. This method will scroll the view by one page up or down and give the focus to the topmost/bottommost component in the new visible area. If no component is a good candidate for focus, this scrollview reclaims the focus.")
  public void VPageScroll(int direction){
    if (scrollView != null) {
      scrollView.pageScroll(direction);
    }
  }
  @SimpleFunction(description="Handles scrolling in response to a 'page up/down' shortcut press. This method will scroll the view by one page up or down and give the focus to the topleft/right component in the new visible area. If no component is a good candidate for focus, this scrollview reclaims the focus.")
  public void HPageScroll(int direction){
    if (hscrollView != null) {
      hscrollView.pageScroll(direction);
    }
  }
  @SimpleFunction(description="Handles scrolling in response to a 'home/end' shortcut press. This method will scroll the view to the top or bottom and give the focus to the topmost/bottommost component in the new visible area. If no component is a good candidate for focus, this scrollview reclaims the focus.")
  public void VFullScroll(int direction){
    if (scrollView != null) {
      scrollView.fullScroll(direction);
    }
  }
  @SimpleFunction(description="Handles scrolling in response to a 'home/end' shortcut press. This method will scroll the view to the left or right and give the focus to the leftmost/rightmost component in the new visible area. If no component is a good candidate for focus, this scrollview reclaims the focus.")
  public void HFullScroll(int direction){
    if (hscrollView != null) {
      hscrollView.fullScroll(direction);
    }
  }
  @SimpleFunction(description="Unregisters previously registered hsa.")
  public void UnregisterHSA(){
    if(hscrollView != null){
      hscrollView = null;
    }
  }
  @SimpleFunction(description="Unregisters previously registered vsa.")
  public void UnregisterVSA(){
    if(scrollView != null){
      scrollView = null;
    }
  }
  @SimpleFunction(description="Fling the vsa with given velocity.Positive numbers mean that the finger/cursor is moving down the screen, which means we want to scroll towards the top.")
  public void VFling(int velocityY){
    if (scrollView != null) {
      scrollView.fling(velocityY);
    }
  }
  @SimpleFunction(description="Fling the hsa with given velocity.Positive numbers mean that the finger/cursor is moving right the screen, which means we want to scroll towards the left.")
  public void HFling(int velocityX){
    if (hscrollView != null) {
      hscrollView.fling(velocityX);
    }
  }
  @SimpleEvent(description="Event raised when a scroll happens in vsa.")
  public void OnVScroll(int scrollY){
    EventDispatcher.dispatchEvent(this,"OnVScroll",scrollY);
  }
  @SimpleEvent(description="Event raised when a scroll happens in hsa.")
  public void OnHScroll(int scrollX){
    EventDispatcher.dispatchEvent(this,"OnHScroll",scrollX);
  }
  @SimpleEvent(description="Event indicating a touch down on hsa.")
  public void OnHTouchDown(){
    EventDispatcher.dispatchEvent(this,"OnHTouchDown");
  }
  @SimpleEvent(description="Event indicating a touch up on hsa.")
  public void OnHTouchUp(){
    EventDispatcher.dispatchEvent(this,"OnHTouchUp");
  }
  @SimpleEvent(description="Event indicating a touch up on vsa.")
  public void OnVTouchUp(){
    EventDispatcher.dispatchEvent(this,"OnVTouchUp");
  }
  @SimpleEvent(description="Event indicating a touch down on vsa.")
  public void OnVTouchDown(){
    EventDispatcher.dispatchEvent(this,"OnVTouchDown");
  }
  /*@SimpleProperty(description = "Sets whether scrolling should be enabled in hsa")
  public void BlockHScroll(boolean block){
      blockHScroll = block;
      if (hscrollView != null){
          hscrollView.setOnTouchListener(new View.OnTouchListener() {
              @Override
              public boolean onTouch(View view, MotionEvent motionEvent) {
                  return blockHScroll;
              }
          });
      }
  }
  @SimpleProperty(description = "Returns whether scrolling is enabled in hsa")
  public boolean BlockHScroll(){
      return blockHScroll;
  }

  @SimpleProperty(description = "Sets whether scrolling should be enabled in vsa")
  public void BlockVScroll(boolean block){
      blockScroll = block;
      if (scrollView != null){
          scrollView.setOnTouchListener(new View.OnTouchListener() {
              @Override
              public boolean onTouch(View view, MotionEvent motionEvent) {
                  return blockScroll;
              }
          });
      }
  }
  @SimpleProperty(description = "Returns whether scrolling is enabled in vsa")
  public boolean BlockVScroll(){
      return blockScroll;
  }*/
  @SimpleProperty(description="Sets the edge effect color for both left and right edge effects of hsa.")
  public void HSetEdgeEffectColor(int color){
    if (hscrollView != null){
      hscrollView.setEdgeEffectColor(color);
    }
  }
  @SimpleProperty(description="Sets the edge effect color for both top and bottom edge effects of vsa.")
  public void VSetEdgeEffectColor(int color){
    if (scrollView != null){
      scrollView.setEdgeEffectColor(color);
    }
  }
  @SimpleProperty(description="Sets the left edge effect color of hsa.")
  public void HSetLeftEdgeEffectColor(int color){
    if (hscrollView != null){
      hscrollView.setLeftEdgeEffectColor(color);
    }
  }
  @SimpleProperty(description="Sets the right edge effect color of hsa.")
  public void HSetRightEdgeEffectColor(int color){
    if (hscrollView != null){
      hscrollView.setRightEdgeEffectColor(color);
    }
  }
  @SimpleProperty(description="Sets the top edge effect color.")
  public void VSetTopEdgeEffectColor(int color){
    if (scrollView != null){
      scrollView.setTopEdgeEffectColor(color);
    }
  }
  @SimpleProperty(description="Returns the top edge effect color of vsa.")
  public int VGetTopEdgeEffectColor(){
    if (scrollView != null){
      return scrollView.getTopEdgeEffectColor();
    }
    return 0;
  }
  @SimpleProperty(description="Returns the right edge effect color of hsa.")
  public int HGetRightEdgeEffectColor(){
    if (hscrollView != null){
      return hscrollView.getRightEdgeEffectColor();
    }
    return 0;
  }
  @SimpleProperty(description="Returns the left edge effect color of hsa.")
  public int HGetLeftEdgeEffectColor(){
    if (hscrollView != null){
      return hscrollView.getLeftEdgeEffectColor();
    }
    return 0;
  }
  @SimpleProperty(description="Sets the bottom edge effect color.")
  public void VSetBottomEdgeEffectColor(int color){
    if (scrollView != null){
      scrollView.setBottomEdgeEffectColor(color);
    }
  }
  @SimpleProperty()
  public void VFadingEdgeEnabled(boolean b){
    if (scrollView != null){
      scrollView.setVerticalFadingEdgeEnabled(b);
    }
  }
  @SimpleFunction()
  public void HFadingEdgeEnabled(boolean b){
    if (hscrollView != null){
      hscrollView.setHorizontalFadingEdgeEnabled(b);
    }
  }
  @SimpleProperty(description="Sets smooth scrolling speed for hsa.Setting it 0 will reset the speed.")
  public void HSmoothScrollSpeed(int millis){
    hScrollSpeed = millis;
  }
  @SimpleProperty(description="Sets smooth scrolling speed for vsa.Setting it 0 will reset the speed.")
  public void VSmoothScrollSpeed(int millis){
    scrollSpeed = millis;
  }

}