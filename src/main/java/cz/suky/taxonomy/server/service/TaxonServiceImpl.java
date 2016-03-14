package cz.suky.taxonomy.server.service;

import cz.suky.taxonomy.server.entity.Taxon;
import cz.suky.taxonomy.server.repository.AuditedEntityRepository;
import cz.suky.taxonomy.server.repository.TaxonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by none_ on 03/14/16.
 */
@Service
public class TaxonServiceImpl extends AuditedEntityServiceImpl<Taxon> implements TaxonService {

    private TaxonRepository taxonRepository;

    @Autowired
    public void setTaxonRepository(TaxonRepository taxonRepository) {
        this.taxonRepository = taxonRepository;
    }

    @Override
    protected AuditedEntityRepository<Taxon> getRepository() {
        return taxonRepository;
    }

    @Override
    protected Taxon safeMap(Taxon source, Taxon target) {
        final Taxon parent = taxonRepository.findOne(source.getParent().getId());
        if (parent == null) {
            throw new IllegalArgumentException("Parent can't be null");
        }
        target.setParent(parent);
        target.setName(source.getName());
        return target;
    }

    @Override
    protected Taxon newEntity() {
        return new Taxon();
    }
}
