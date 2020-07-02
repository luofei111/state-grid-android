import 'package:flutter/material.dart';

class MessagePage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return new _MessagePage();
  }
}

class _MessagePage extends State<MessagePage> {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new Scaffold(
      body: new Center(
        child: Text('消息'),
      ),
    );
  }
}
