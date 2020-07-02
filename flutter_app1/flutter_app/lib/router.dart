import 'package:flutter/material.dart';
import 'package:flutter_app/login.dart';

class Router {

  static const loginPage = 'app://LoginPage';

  Router.push(BuildContext context, String url, dynamic params) {
    Navigator.push(context, MaterialPageRoute(builder: (context) {
      return _getPage(url, params);
    }));
  }

  Widget _getPage(String url, dynamic params) {
    switch (url) {
      case loginPage:
        return new LoginPage();
    }

    return null;
  }
}
