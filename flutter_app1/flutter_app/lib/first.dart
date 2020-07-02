import 'package:flutter/material.dart';
import 'package:meta/meta.dart';
import 'second.dart';
import 'login.dart';

/**
 * 跳转到新页面并返回
 */
void main() {
  //application
  runApp(new MaterialApp(
    //application名字
    title: "FlutterApplication",
    //页面
    home: new FirstPage(),
  ));
}

/**
 * 第一个页面
 */
class FirstPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    /*return new Scaffold(
      appBar: new AppBar(
        title: new Text("第一个页面"),
      ),
      body: new Center(
        child: new RaisedButton(
            child: new Text("点我进入第二个页面"),
            onPressed: () {
              // 跳转到新的 页面我们需要调用 navigator.push方法 这个和eactNative的方式相同
              Navigator.push(
                  context,
                  new MaterialPageRoute(
                      builder: (context) => new LoginPage()));
            }),
      ),
    );*/

    return new MaterialApp(
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text("第一个页面"),
        ),
        body: new Center(
          child: new RaisedButton(
              child: new Text("点我进入第二个页面"),
              onPressed: () {
                // 跳转到新的 页面我们需要调用 navigator.push方法 这个和eactNative的方式相同
                Navigator.push(
                    context,
                    new MaterialPageRoute(
                        builder: (context) => new LoginPage()));
              }),
        ),
      ),
    );
  }
}