import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

/**
 * 第二个页面
 */
class SecondPage extends StatelessWidget {

  SecondPage({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("第二个页面"),
      ),
      body: new Center(
        //onPressed  点击事件
        child: new RaisedButton(
            child: new Text("点我回第一个页面"),
            onPressed: () {
              //回到上一个页面 相当于finsh
              Navigator.pop(context);
            }),
      ),
    );
  }
}
