(ns frontendfi.env
  (:require [clojure.tools.logging :as log]
            [frontendfi.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[frontendfi started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[frontendfi has shutdown successfully]=-"))
   :middleware wrap-dev})
