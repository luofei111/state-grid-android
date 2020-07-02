import 'package:flutter/material.dart';
import 'index.dart';
import 'message.dart';
import 'asset.dart';
import 'my.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: '瀛饭碗',
      theme: ThemeData(
        primarySwatch: Colors.indigo
      ),
      home: MyHomePage(title: '瀛饭碗'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);
  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  var _currentIndex = 0;

  IndexPage indexPage;
  MessagePage messagePage;
  AssetPage assetPage;
  MyPage myPage;

  currentPage() {
    switch (_currentIndex) {
      case 0:
        indexPage = new IndexPage();
        return indexPage;
        break;
      case 1:
        messagePage = new MessagePage();
        return messagePage;
        break;
      case 2:
        assetPage = new AssetPage();
        return assetPage;
        break;
      case 3:
        myPage = new MyPage();
        return myPage;
        break;
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
     /* appBar: AppBar(
        title: Text(widget.title),
      ),*/

      bottomNavigationBar: new BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        currentIndex: _currentIndex,
        onTap: ((index) {
          setState(() {
            _currentIndex = index;
          });
        }),
        items: [
          new BottomNavigationBarItem(
              icon: _currentIndex == 0
                  ? Image.asset(
                      'images/tab_home_selected.png',
                      width: 25.0,
                      height: 25.0,
                    )
                  : Image.asset(
                      'images/tab_home_normal.png',
                      width: 25.0,
                      height: 25.0,
                    ),
              title: new Text(
                '店铺',
                style: TextStyle(
                    color: _currentIndex == 0
                        ? Color(0xFF455b96)
                        : Color(0xff000000)),
              )),
          new BottomNavigationBarItem(
              icon: _currentIndex == 1
                  ? Image.asset(
                      'images/tab_message_selected.png',
                      width: 25.0,
                      height: 25.0,
                    )
                  : Image.asset(
                      'images/tab_message_normal.png',
                      width: 25.0,
                      height: 25.0,
                    ),
              title: new Text(
                '消息',
                style: TextStyle(
                    color: _currentIndex == 1
                        ? Color(0xFF455b96)
                        : Color(0xff000000)),
              )),
          new BottomNavigationBarItem(
              icon: _currentIndex == 2
                  ? Image.asset(
                      'images/tab_zichan_selected.png',
                      width: 25.0,
                      height: 25.0,
                    )
                  : Image.asset(
                      'images/tab_zichan_normal.png',
                      width: 25.0,
                      height: 25.0,
                    ),
              title: new Text(
                '资产大厅',
                style: TextStyle(
                    color: _currentIndex == 2
                        ? Color(0xFF455b96)
                        : Color(0xff000000)),
              )),
          new BottomNavigationBarItem(
              icon: _currentIndex == 3
                  ? Image.asset(
                'images/tab_me_selected.png',
                width: 25.0,
                height: 25.0,
              )
                  : Image.asset(
                'images/tab_me_normal.png',
                width: 25.0,
                height: 25.0,
              ),
              title: new Text(
                '我的',
                style: TextStyle(
                    color: _currentIndex == 3
                        ? Color(0xFF455b96)
                        : Color(0xff000000)),
              )),
        ],
      ),

      body:
          currentPage(), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
