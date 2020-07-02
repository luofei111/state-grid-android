import 'package:flutter/material.dart';

class MyPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return new _MyPage();
  }
}

class _MyPage extends State<MyPage> {
  @override
  Widget build(BuildContext context) {
    /*顶部信息部分*/
    Widget topInfoContiner = Container(
      padding: const EdgeInsets.only(
          left: 20.0, top: 40.0, right: 5.0, bottom: 20.0),
      color: const Color(0xff59618B),
      child: Row(
        children: <Widget>[
          /* 头像*/
          Container(
            padding: const EdgeInsets.only(right: 10.0),
            child: Image.network(
              'https://ts.bmbs.tech/yingfanwan/201905/30/00ab78fb6bd54da99e9d7a73e499699b.png',
              width: 75.0,
              height: 75.0,
              fit: BoxFit.fill,
            ),
          ),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                Container(
                  padding: const EdgeInsets.only(bottom: 8.0),
                  child: new Text(
                    '好主人欢快旗舰店好主人欢快旗舰店好主人欢快旗舰店好主人欢快旗舰店好主人欢快旗舰店',
                    maxLines: 2,
                    style: TextStyle(
                      fontSize: 22.0,
                      color: Colors.white,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
                new Row(
                  children: <Widget>[
                    Container(
                      padding: const EdgeInsets.only(
                          left: 5.0, top: 2.0, right: 5.0, bottom: 2.0),
                      child: new Text(
                        '营业中',
                        style: new TextStyle(
                          fontSize: 14.0,
                          color: Colors.white,
                        ),
                      ),
                      decoration: new BoxDecoration(
                        color: Colors.yellow,
                        borderRadius:
                            new BorderRadius.all(new Radius.circular(4.0)),
                      ),
                    ),
                    Container(
                        padding: const EdgeInsets.only(left: 5.0),
                        child: new Text(
                          '18200394079',
                          style: new TextStyle(
                            fontSize: 16.0,
                            color: Colors.white,
                          ),
                        )),
                  ],
                ),
              ],
            ),
          ),
          new IconButton(
            onPressed: () {
              // 跳转页面
              //Router.push(context, Router.loginPage, '');
              /*  Navigator.push(context,
                  new MaterialPageRoute(builder: (context) => new LoginPage()));*/
            },
            icon: Icon(
              Icons.arrow_forward,
              color: Colors.yellow,
              size: 25.0,
            ),
          ),
        ],
      ),
    );

    /*二维码及关注信息部分*/
    Widget secondInfoContiner = Container(
      padding: const EdgeInsets.all(12.0),
      color: Color(0xffffffff),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: <Widget>[
          /*店铺二维码*/
          new Center(
            child: Row(
              children: <Widget>[
                Text(
                  '店铺二维码',
                  style: TextStyle(
                    fontSize: 16.0,
                    color: const Color(0xff909090),
                  ),
                ),
                Icon(
                  Icons.assignment,
                  color: Colors.grey,
                ),
              ],
            ),
          ),

          /*店铺关注数*/
          new Center(
            child: Row(
              children: <Widget>[
                Text(
                  '店铺关注数：',
                  style: TextStyle(
                    fontSize: 16.0,
                    color: const Color(0xff909090),
                  ),
                ),
                Text(
                  '0',
                  style: TextStyle(
                    fontSize: 16.0,
                    color: const Color(0xff909090),
                  ),
                )
              ],
            ),
          ),
        ],
      ),
    );

    /*菜单项构建*/
    Container builtMenuItemContainer(IconData icon, String label) {
      return Container(
        padding: EdgeInsets.all(10.0),
        color: Color(0xffffffff),
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            Icon(
              icon,
              color: Color(0xfffe7d32),
            ),
            Container(
              padding: EdgeInsets.only(left: 10.0),
              child: Text(
                label,
                style: TextStyle(
                  fontSize: 16.0,
                  color: Color(0xffe1333333),
                ),
              ),
            ),
          ],
        ),
      );
    }

    // TODO: implement build
    return new Scaffold(
      backgroundColor: Color(0xfff7f7f8),
      /*标题栏*/
      /*appBar: new AppBar(
          title: new Text(""),
          backgroundColor: Color(0xff59618B),
        ),*/

      body: ListView(
        children: <Widget>[
          topInfoContiner,
          secondInfoContiner,
          Container(
            padding: EdgeInsets.only(top: 10.0, bottom: 10),
            child: builtMenuItemContainer(Icons.launch, '账号资金'),
          ),
          builtMenuItemContainer(Icons.print, '卖出资产'),
          builtMenuItemContainer(Icons.save, '买入资产'),
          builtMenuItemContainer(Icons.select_all, '我的收藏'),
          Container(
            padding: EdgeInsets.only(top: 10.0, bottom: 10),
            child: builtMenuItemContainer(Icons.account_balance, '城市合伙人'),
          ),
          builtMenuItemContainer(Icons.feedback, '意见反馈'),
          builtMenuItemContainer(Icons.settings, '设置'),
        ],
      ),
    );
    //);
  }
}
