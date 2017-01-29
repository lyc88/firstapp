package com.lyc88.services;

import com.lyc88.base.BaseService;
import com.lyc88.beans.DiskFiles;

/**
 * Created by Administrator on 2017/1/26.
 */
public interface DiskFilesService extends BaseService<DiskFiles> {
    public void scanDisk();
}
