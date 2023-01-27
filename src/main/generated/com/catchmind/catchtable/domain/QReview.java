package com.catchmind.catchtable.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = 963963893L;

    public static final QReview review = new QReview("review");

    public final QAuditingFields _super = new QAuditingFields(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath orgNm = createString("orgNm");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath revContent = createString("revContent");

    public final NumberPath<Long> revLike = createNumber("revLike", Long.class);

    public final NumberPath<Double> revScore = createNumber("revScore", Double.class);

    public final StringPath savedNm = createString("savedNm");

    public final StringPath savedPath = createString("savedPath");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public QReview(String variable) {
        super(Review.class, forVariable(variable));
    }

    public QReview(Path<? extends Review> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReview(PathMetadata metadata) {
        super(Review.class, metadata);
    }

}

