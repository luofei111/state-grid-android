import 'package:flutter/material.dart';

void main() => runApp(new MaterialApp(
      title: "imagedemo",
      home: new ImageDamo(
        items: new List<String>.generate(500, (i) => 'Item$i'),
      ),
    ));

class ImageDamo extends StatelessWidget {
  final List<String> items;

  ImageDamo({Key key, @required this.items}) : super(key: key);

  String url =
      'https://ts.bmbs.tech/yingfanwan/201905/30/e15f4578872b4c1183a63531bde6a78c.png';

  var list = <Widget>[
    ListTile(
      leading: Icon(Icons.alarm),
      title: Text("add_alarm"),
    ),
  ];

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("Flutter_Test"),
      ),
      body: Container(
        child: Image(
          image: AssetImage('assets/images/abc.png'),
          width: 100.0,
          height: 100.0,
        ),
      ),
      /*body: new Container(
          child: new Column(
            children: <Widget>[
          new Text(
          'Flutter_弗拉特',
            style: new TextStyle(
              color: const Color(0xffff0000),
              decoration: TextDecoration.lineThrough,
              decorationColor: const Color(0xff000000),
              fontStyle: FontStyle.italic,
              fontWeight: FontWeight.bold,
              fontSize: 25.0,
            ),
          ),
          new Image.network(
            url,
            fit: BoxFit.fitWidth,
          ),
          new Icon(
            Icons.phone,
            color: Colors.green[500],
            size: 40.0,
            textDirection: TextDirection.ltr,
          ),
          */ /* new IconButton(
                  icon: Icon(
                    Icons.print,
                    size: 45.0,
                    ed: () {},
                color: Colors.green,
                child: new Text('RaisedButton'),
              )
            ],
          ),*/ /*
        )*/
      /*body: new ListView(
        children: <Widget>[
          ListTile(
            leading: Icon(Icons.alarm),
            title: Text("add_alarm"),
          ),ListTile(
            leading: Icon(Icons.alarm),
            title: Text("add_alarm"),
          ),
        ],
      ),*/

      /*body: new ListView.builder(
        itemCount: items.length,
        itemBuilder: (context, index) {
          return new ListTile(
            leading: new Icon(Icons.add),
            title: new Text('${items[index]}'),
            subtitle: new Text(
              'Flutter_弗拉特',
              style: new TextStyle(
                color: const Color(0xffff0000),
                fontSize: 14.0,
              ),
            ),
          );
        },
      ),*/
    );
  }
}
