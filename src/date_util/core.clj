(ns date-util.core
  (:require [clojure.instant :refer [read-instant-date]])
  (:import [java.time LocalDate ZoneId]))

(defn parse-date [date-str]
  (-> date-str
      read-instant-date
      .toInstant
      (.atZone (ZoneId/systemDefault))
      .toLocalDate))

(defn now []
  (LocalDate/now))

(defn plus-days [^LocalDate d days]
  (.plusDays d days))

(defn date [y m d]
  (LocalDate/of y m d))

(defn add-days [date-str days]
  (-> date-str
      parse-date
      (plus-days days)))

(defn plus-60 [date-str]
  (add-days date-str 60))

(defn plus-120 [date-str]
  (add-days date-str 120))

(comment
  *e
  (parse-date "2017-08-23")

  (bean (parse-date "2017-08-23"))

  (-> "2022-09-12"
      plus-60
      str)
  
  (-> "2022-09-12"
      plus-120
      str)


  ;;
  )