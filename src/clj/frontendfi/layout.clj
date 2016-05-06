(ns frontendfi.layout
  (:require [selmer.parser :as parser]
            [selmer.filters :as filters]
            [markdown.core :refer [md-to-html-string]]
            [ring.util.http-response :refer [content-type ok]]
            [ring.util.anti-forgery :refer [anti-forgery-field]]
            [ring.middleware.anti-forgery :refer [*anti-forgery-token*]]
            [hiccup.core :as hiccup]
            [frontendfi.views.home :refer [error]]))

(declare ^:dynamic *identity*)
(declare ^:dynamic *app-context*)
#_(parser/set-resource-path!  (clojure.java.io/resource "templates"))
#_(parser/add-tag! :csrf-field (fn [_ _] (anti-forgery-field)))
#_(filters/add-filter! :markdown (fn [content] [:safe (md-to-html-string content)]))

#_(defn render
  "renders the HTML template located relative to resources/templates"
  [template & [params]]
  (content-type
    (ok
      (parser/render-file
        template
        (assoc params
          :page template
          :csrf-token *anti-forgery-token*
          :servlet-context *app-context*)))
    "text/html; charset=utf-8"))

(defn render
  [hiccup-fn & [params]]
  (content-type
    (ok
      (hiccup/html (hiccup-fn (assoc params
                                :csrf-token *anti-forgery-token*
                                :servlet-context *app-context*))))
    "text/html; charset=utf-8"))

(defn error-page
  "error-details should be a map containing the following keys:
   :status - error status
   :title - error title (optional)
   :message - detailed error message (optional)

   returns a response map with the error page as the body
   and the status specified by the status key"
  [error-details]
  {:status  (:status error-details)
   :headers {"Content-Type" "text/html; charset=utf-8"}
   :body    ((error) (merge
                       error-details
                       {:message "Luckily it's not the end of the world!"}))})
