# ProgressView
简单进度条

### 截图
<img src="./sc1.png" width="300">

### 使用
1.导入依赖
```java
compile 'com.diffey.view.progressview:progressview:0.2.0'
```

2.布局中使用
```java
    <com.diffey.view.progressview.ProgressView
        android:layout_width="match_parent"
        android:layout_height="40dp"
        progressview:backgroundColor="#eee"
        progressview:max="100"
        progressview:progress="80"
        progressview:progressColor="#6e63bf"
        progressview:text="积极性 80%"
        progressview:textColor="#eee"
        progressview:textLeftPadding="5dp"
        progressview:textSize="25sp" />
``` 
