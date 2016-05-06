(ns frontendfi.views
  (:require [hiccup.page :as page]
            [hiccup.element :as el]))

(defn- boilerplate-js [token context]
  (str "var context = " context ";
  var csrfToken = " token ";"))

(def error-css
  " html {
        height: 100%;
                min-height: 100%;
        min-width: 100%;
        overflow: hidden;
        width: 100%;
        }
  html body {
             height: 100%;
                     margin: 0;
                     padding: 0;
                     width: 100%;
             }
  html .container-fluid {
                         display: table;
                         height: 100%;
                                  padding: 0;
                                  width: 100%;
                         }
  html .row-fluid {
                   display: table-cell;
                   height: 100%;
                            vertical-align: middle;
                   }")

(defn main []
  (fn [{:keys [csrf-token servlet-context]}]
    (page/html5
     {}
     [:head
      [:meta
       {:content "text/html; charset=UTF-8", :http-equiv "Content-Type"}]
      [:meta
       {:content "width=device-width, initial-scale=1", :name "viewport"}]
      [:title "Welcome to frontendfi"]]
     [:body
      [:div#navbar]
      [:div#app
       [:div.container
        [:div.three-quarters-loader "Loading…"]
        [:p
         "If you're seeing this message, that means you haven't yet compiled your ClojureScript!"]
        [:p
         "Please run "
         [:code "lein figwheel"]
         " to start the ClojureScript compiler and reload the page."]
        [:p
         "See "
         [:a
          {:href "http://www.luminusweb.net/docs/clojurescript.md"}
          "ClojureScript"]
         " documentation for further details."]]]
      [:div.example [:div.example-title "Controls"] [:div#controls]]
      (page/include-css "/assets/bootstrap/css/bootstrap.min.css")
      (page/include-css "/assets/font-awesome/css/font-awesome.min.css")
      (page/include-css "/css/screen.css")
      (el/javascript-tag (boilerplate-js csrf-token servlet-context))
      (page/include-js "/js/app.js")])))

(defn error []
  (fn [{:keys [status title message]}]
    (page/html5
      {}
      [:head
       [:title "Something bad happened"]
       [:meta
        {:content "text/html; charset=UTF-8", :http-equiv "Content-Type"}]
       [:meta
        {:content "width=device-width, initial-scale=1.0",
         :name    "viewport"}]
       (page/include-css "/assets/bootstrap/css/bootstrap.min.css")
       (page/include-css "/assets/font-awesome/css/font-awesome.min.css")
       [:style
        {:type "text/css"}
        error-css]]
      [:body
       [:div.container-fluid
        [:div.row-fluid
         [:div.col-lg-12
          [:div.centering.text-center
           [:div.text-center
            [:h1 [:span.text-danger (str "Error: " status)]]
            [:hr]
            (when title [:h2.without-margin title])
            (when message [:h4.text-danger message])]]]]]])))