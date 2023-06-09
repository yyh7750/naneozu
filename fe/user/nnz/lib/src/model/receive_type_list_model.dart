class ReceiveTypeList {
  bool? isFirst;
  bool? isLast;
  bool? isEmpty;
  int? totalElements;
  int? totalPages;
  List<Content2>? content;

  ReceiveTypeList(
      {this.isFirst,
      this.isLast,
      this.isEmpty,
      this.totalElements,
      this.totalPages,
      this.content});

  ReceiveTypeList.fromJson(Map<String, dynamic> json) {
    isFirst = json['isFirst'];
    isLast = json['isLast'];
    isEmpty = json['isEmpty'];
    totalElements = json['totalElements'];
    totalPages = json['totalPages'];
    if (json['content'] != null) {
      content = <Content2>[];
      json['content'].forEach((v) {
        content!.add(new Content2.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['isFirst'] = this.isFirst;
    data['isLast'] = this.isLast;
    data['isEmpty'] = this.isEmpty;
    data['totalElements'] = this.totalElements;
    data['totalPages'] = this.totalPages;
    if (this.content != null) {
      data['content'] = this.content!.map((v) => v.toJson()).toList();
    }
    return data;
  }
}

class Content2 {
  int? id;
  String? thumbnail;
  String? title;
  String? date;
  String? location;
  bool? isCertification;
  int? status;

  Content2(
      {this.id,
      this.thumbnail,
      this.title,
      this.date,
      this.location,
      this.isCertification,
      this.status});

  Content2.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    thumbnail = json['thumbnail'];
    title = json['title'];
    date = json['date'];
    location = json['location'];
    isCertification = json['isCertification'];
    status = json['status'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    data['thumbnail'] = this.thumbnail;
    data['title'] = this.title;
    data['date'] = this.date;
    data['location'] = this.location;
    data['isCertification'] = this.isCertification;
    data['status'] = this.status;
    return data;
  }
}
